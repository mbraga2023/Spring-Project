package com.websitespring.AppConsole.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitespring.AppConsole.models.Administrador;
import com.websitespring.AppConsole.repositorio.AdministradoresRepo;

@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;// controlador do Bando de Dados

    @GetMapping("/login")
    public String index(){   
        return "/login/index";
    }

     @PostMapping("/logar")
    public String logar(@RequestParam("email") String email,
                               @RequestParam("senha") String senha,
                               Model model) {
        Administrador administrador = repo.findByEmailAndSenha(email, senha);
        if (administrador != null) {
            // Successful login, you can set up the user session or authentication here
            return "redirect:/"; // Redirect to the home page after successful login
        } else {
            model.addAttribute("erro", "Usuário ou senha inválidos");
            return "login/index"; // Return to the login form with an error message
        }

    }
    
}
