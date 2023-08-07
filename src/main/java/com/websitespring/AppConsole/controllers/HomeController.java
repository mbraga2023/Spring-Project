package com.websitespring.AppConsole.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.websitespring.AppConsole.Servico.CookieService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @GetMapping("/")
  public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException{

        model.addAttribute("nome", CookieService.getCookie(request, "user_name")); //set attibute in main page
        
        return "/home/index";
    }


    
}
