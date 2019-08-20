package br.com.fiap.rest.api;

import br.com.fiap.rest.entity.Musica;
import br.com.fiap.rest.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musica")
public class MusicaResource {
    @Autowired
    private MusicaRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Musica cadastrar(@RequestBody Musica mus){
        return repository.save(mus);
    }

    @GetMapping
    public List<Musica> listar(){
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Musica buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }

    @GetMapping("pesquisaNome")
    public List<Musica> listarPorNome(@RequestParam String nome){
        return repository.findByNome(nome);
    }

    @GetMapping("pesquisaDuracao")
    public List<Musica> listarPorDuracao(@RequestParam int duracao){
        return repository.findByDuracao(duracao);
    }

    @PutMapping("{codigo}")
    public Musica atualizar(@RequestBody Musica mus,@PathVariable int codigo){
        mus.setCodigo(codigo);
        return repository.save(mus);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }





}
