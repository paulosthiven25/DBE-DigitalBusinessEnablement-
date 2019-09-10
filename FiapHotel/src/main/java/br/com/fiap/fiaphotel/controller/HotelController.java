package br.com.fiap.fiaphotel.controller;

import br.com.fiap.fiaphotel.model.Hotel;
import br.com.fiap.fiaphotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("hotel")
public class HotelController {
    @Autowired
    private HotelRepository hp;
    @GetMapping("cadastrar")
    public String abrirCadastro(Hotel hotel){
        return "hotel/cadastro";
    }


    @GetMapping("editar/{id}")
    public String abrirModoeditar(@PathVariable("id") int codigo, Model m){
        m.addAttribute("hotel",hp.findById(codigo).get());
        return "hotel/cadastro";
    }

    @PostMapping("cadastrar")
    public String processarDadosCadastro(Hotel h, RedirectAttributes r){
        r.addFlashAttribute("msg",h.getCodigo()==0?"Cadastrado":"Atualizado");
        hp.save(h);
        return "redirect:/hotel/listar";
    }

    @GetMapping("listar")
    public String listarTodosHotel(Model model){
        model.addAttribute("lista",hp.findAll());
        return "hotel/listagem";
    }

    @PostMapping("remover")
    public String removerHotel(int id,RedirectAttributes r){
       Hotel h = hp.findById(id).get();
        hp.delete(h);
        r.addFlashAttribute("msg","hotel removido");
        return "redirect:/hotel/listar";
    }

}
