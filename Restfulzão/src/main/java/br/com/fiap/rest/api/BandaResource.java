package br.com.fiap.rest.api;

import br.com.fiap.rest.entity.Banda;
import br.com.fiap.rest.entity.Musica;
import br.com.fiap.rest.repository.BandaRepository;
import br.com.fiap.rest.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("banda")
public class BandaResource {

    @Autowired
    private BandaRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Banda cadastrar(@RequestBody Banda ban){
        return repository.save(ban);
    }

    @GetMapping
    public List<Banda> listar(){
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Banda buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }



    @PutMapping("{codigo}")
    public Banda atualizar(@RequestBody Banda banda,@PathVariable int codigo){
        banda.setCodigo(codigo);
        return repository.save(banda);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }

}
