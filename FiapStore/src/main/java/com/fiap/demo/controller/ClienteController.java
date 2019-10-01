package com.fiap.demo.controller;

import com.fiap.demo.Model.Cliente;
import com.fiap.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteRepository cr;
    @GetMapping("cadastrar")
    public String abrirForm(Cliente cliente){

        return "cliente/cadastro";
    }

    @PostMapping("salvar")
    public String cadastrarDados(@Valid Cliente cliente, BindingResult br, RedirectAttributes r){
        if(br.hasErrors()){
        return "cliente/cadastro";}
        cr.save(cliente);
        r.addFlashAttribute("msg","cliente cadastrado");
        return "redirect:/cliente/cadastrar";
    }



}
