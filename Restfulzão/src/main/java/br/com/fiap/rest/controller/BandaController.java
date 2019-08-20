package br.com.fiap.rest.controller;

import br.com.fiap.rest.entity.Banda;
import br.com.fiap.rest.repository.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("banda")
public class BandaController {

    @Autowired
    private BandaRepository repository;

    @GetMapping("/cadastrar")
    public String abrirFormulario(){
        return "Banda/cadastro";
    }


    @PostMapping("/cadastrar")
    public String processarForm(Banda ban, Model m){
        repository.save(ban);
        m.addAttribute("msg","CADASTRADO!");
        return "Banda/cadastro";
    }

}
