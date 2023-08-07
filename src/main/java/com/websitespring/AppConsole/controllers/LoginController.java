package com.websitespring.AppConsole.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitespring.AppConsole.Servico.CookieService;
import com.websitespring.AppConsole.models.Administrador;
import com.websitespring.AppConsole.repositorio.AdministradoresRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;// controlador do Bando de Dados

    @GetMapping("/login")
    public String index() {
        return "/login/index";
    }

    @PostMapping("/logar")
    public String processLogin(@RequestParam("email") String email,
            @RequestParam("senha") String senha,
            String lembrar,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        Administrador administrador = repo.findByEmailAndSenha(email, senha);
        if (administrador != null) {
            // Successful login, you can set up the user session or authentication here
            // Get the name from the Administrador object
            String name = administrador.getNome();

            Cookie emailCookie = new Cookie("user_email", email);
            emailCookie.setMaxAge(60 * 60); // 1 hour in seconds
            response.addCookie(emailCookie);

            Cookie nameCookie = new Cookie("user_name", name);
            nameCookie.setMaxAge(60 * 60); // 1 hour in seconds
            response.addCookie(nameCookie);

            //Check if "lembrar" checkbox is checked

            if (lembrar != null && lembrar.equals("on")) {
                // Create a cookie for the email and set it to expire in 30 days (adjust the max
                // age as needed)
                Cookie emailCookieLong = new Cookie("user_email", email);
                emailCookieLong.setMaxAge(30 * 24 * 60 * 60); // 30 days in seconds
                response.addCookie(emailCookieLong);

                // You can create another cookie for the "lembrar" checkbox if needed
                // Cookie lembrarCookie = new Cookie("lembrar", "true");
                // lembrarCookie.setMaxAge(30 * 24 * 60 * 60);
                // response.addCookie(lembrarCookie);
            }

            return "redirect:/"; // Redirect to the home page after successful login
        } else {
            model.addAttribute("erro", "Usuário ou senha inválidos");
            return "login/index"; // Return to the login form with an error message
        }
    }

    @GetMapping("/sair")
    public String logout(HttpServletResponse response) throws IOException {
        CookieService.setCookie(response, "user_email", "", 0);
                CookieService.setCookie(response, "user_name", "", 0);
        return "redirect:login/index";
    }
}
