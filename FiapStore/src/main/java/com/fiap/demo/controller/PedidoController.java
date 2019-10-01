package com.fiap.demo.controller;

import com.fiap.demo.Model.Cliente;
import com.fiap.demo.Model.Pedido;
import com.fiap.demo.repository.ClienteRepository;
import com.fiap.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    ClienteRepository cr;
    @GetMapping("listar")
    public String abrirLista(){
        return "pedido/lista";
    }

    @GetMapping("pesquisarNome")
    public String pesquisarNome(String nomeBusca, Model model){
        model.addAttribute("lista",cr.findByNomeContainsIgnoreCase(nomeBusca));
        return "pedido/lista";
    }

    @GetMapping("cadastrar/{id}")
    public String abrirForm(@PathVariable("id") int codigo , Pedido pedido, Model model){
        Cliente cliente = cr.findById(codigo).get();
        pedido.setCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "pedido/cadastro";
    }
}
