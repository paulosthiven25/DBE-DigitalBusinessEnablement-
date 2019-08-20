package br.com.fiap.rest.controller;

import br.com.fiap.rest.entity.Musica;
import br.com.fiap.rest.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("musica")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @GetMapping("/cadastrar")
    public String abrirFormulario(){
        return "Musica/cadastroMusica";
    }


    @PostMapping("/cadastrar")
            public String processarForm(Musica muc, Model m){
        repository.save(muc);
        m.addAttribute("msg","CADASTRADO!");
        return "Musica/cadastroMusica";
    }

}
