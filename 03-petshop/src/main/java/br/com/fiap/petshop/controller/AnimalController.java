package br.com.fiap.petshop.controller;

import br.com.fiap.petshop.model.Animal;
import br.com.fiap.petshop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String cadastrar(Animal animal, RedirectAttributes r){
        ap.save(animal);
        r.addFlashAttribute("msg","CADASTRADO!");
        return "redirect:/animal/listar";
    }

    @GetMapping("listar")
    public String cadastrar(Model model){
        model.addAttribute("lista",ap.findAll());
        return "animal/listagem";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo,Model model){
        model.addAttribute("animal",ap.findById(codigo));
        return "animal/atualizacao";
    }

    @PostMapping("editar")
    public String atualizar (Animal animal, RedirectAttributes r){
        ap.save(animal);
      r.addFlashAttribute("msg","Atualizado");
        return "redirect:/animal/listar";
    }

    @PostMapping("excluir")
    public String excluir (int codigo,RedirectAttributes r){
        ap.deleteById(codigo);
        r.addFlashAttribute("msg","apagado");
        return "redirect:/animal/listar";
    }

    @GetMapping("listaRaca")
    public String listaPorNome (String consulta,Model m){

        m.addAttribute("lista",ap.findByRaca(consulta));
        return "animal/listagem";
    }

}
