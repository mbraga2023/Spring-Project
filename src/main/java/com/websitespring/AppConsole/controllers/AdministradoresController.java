package com.websitespring.AppConsole.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.websitespring.AppConsole.models.Administrador;
import com.websitespring.AppConsole.repositorio.AdministradoresRepo;

@Controller
public class AdministradoresController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/administradores")
    public String index(Model model){
        List<Administrador> administradores = (List<Administrador>)repo.findAll();

        model.addAttribute("administradores", administradores); 
        //buscando parametro administradores
        return "/administradores/index";
    }

     @GetMapping("/administradores/novo")
    public String novo(){
        return "/administradores/novo";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador){//objeto da classe model
        repo.save(administrador);
        //objeto ligado com o BD com todas as info
        //save = INSERT
        return "redirect:/administradores";
    }
     @GetMapping("/administradores/{id}/excluir")//id admin passado no parametro
    public String excluir(@PathVariable int id){
        repo.deleteById(id);   
    
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String busca(@PathVariable int id, Model model){
      Optional<Administrador> admin = repo.findById(id);
      try{
        model.addAttribute("administrador", admin.get());
      }
      catch(Exception err){ return "redirect:/administradores"; }
  
      return "/administradores/editar";
    }
  
    @PostMapping("/administradores/{id}/atualizar")
    public String atualizar(@PathVariable int id, Administrador administrador){
      // if(!repo.exist(id)){ metodo usado na classe principal
      if(!repo.existsById(id)){
        return "redirect:/administradores";
      }
  
      repo.save(administrador);
  
      return "redirect:/administradores";
    }
    
}
