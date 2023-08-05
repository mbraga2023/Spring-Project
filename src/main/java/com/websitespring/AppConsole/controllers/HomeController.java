package com.websitespring.AppConsole.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("nome", "Michel"); //set attibute in main page
        
        return "/home/index";
    }


    
}
