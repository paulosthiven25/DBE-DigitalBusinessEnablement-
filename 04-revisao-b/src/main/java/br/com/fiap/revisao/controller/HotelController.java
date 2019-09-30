package br.com.fiap.revisao.controller;

import br.com.fiap.revisao.model.Hotel;
import br.com.fiap.revisao.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelRepository repository;

    @GetMapping("pesquisar")
    public String pesquisar(String termoPesquisa, Model model){
        model.addAttribute("lista", repository.findByNomeContainsIgnoreCase(termoPesquisa));
        return "hotel/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Hotel hotel){
        return "hotel/form";
    }

    @PostMapping("salvar")
    public String salvar(@Valid Hotel hotel, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            return "hotel/form";
        }

        redirect.addFlashAttribute("msg",hotel.getCodigo()==0?"Cadastrado!":"Atualizado!");
        repository.save(hotel);
        return "redirect:/hotel/listar";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("lista", repository.findAll());
        return "hotel/lista";
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("hotel", repository.findById(codigo).get());
        return "hotel/form";
    }

    @PostMapping("excluir")
    public String remover(int codigo, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg", "Removido!");
        repository.deleteById(codigo);
        return "redirect:/hotel/listar";
    }

}
