package br.com.fiap.revisao.controller;

import br.com.fiap.revisao.model.Quarto;
import br.com.fiap.revisao.model.Reserva;
import br.com.fiap.revisao.repository.QuartoRepository;
import br.com.fiap.revisao.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
    QuartoRepository qr;
    ReservaRepository rr;
    @GetMapping("quartos")
    public String listarQuartosReserva(Model model){
model.addAttribute("lista",qr.findAll());
        return "reserva/listaQuartos";
    }

    @GetMapping("agendar/{codigo}")
    public String agendarReserva(@PathVariable("codigo") int codigo, Model m, Reserva r)
    {
       Quarto quarto=qr.findById(codigo).get();
       r.setQuarto(quarto);
        return "reserva/reservaCadastro";
    }

    @PostMapping("agendar")
    public String agendarReserva( Model m, Reserva r){
        rr.save(r);
        return "reserva/listaQuartos";
    }
}
