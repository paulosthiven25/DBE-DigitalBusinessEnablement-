package br.com.fiap.revisao.controller;

import br.com.fiap.revisao.model.Quarto;
import br.com.fiap.revisao.repository.HotelRepository;
import br.com.fiap.revisao.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quarto")
public class QuartoController {
    @Autowired
    private QuartoRepository qr;
    @Autowired
    private HotelRepository hr;
    @GetMapping("cadastrar")
    public String abrirForm(Model m,Quarto quarto){
        m.addAttribute("hoteis",hr.findAll());
        return "quarto/cadastro";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Quarto q,int codigoHotel){
        q.setHotel(hr.findById(codigoHotel).get());
        qr.save(q);
        return "quarto/lista";
    }

    @GetMapping("listar")
    public String listar (Model m){
        m.addAttribute("quartos",qr.findAll());
        return "quarto/lista";
    }

}
