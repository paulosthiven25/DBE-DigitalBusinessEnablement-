package br.com.fiap.petshop.controller;

import br.com.fiap.petshop.model.Animal;
import br.com.fiap.petshop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("animal")
public class AnimalController {
    @Autowired
    private AnimalRepository ap;
    @GetMapping("cadastrar")
    public String cadastrar(Animal animal){
        return "animal/cadastro";
    }


    @PostMapping("cadastrar")
    public String cadastrar(Animal animal, Model model){
        ap.save(animal);
        model.addAttribute("msg","CADASTRADO!");
        return "animal/cadastro";
    }

    @GetMapping("listar")
    public String cadastrar(Model model){
        model.addAttribute("lista",ap.findAll());
        return "animal/listagem";
    }
}
