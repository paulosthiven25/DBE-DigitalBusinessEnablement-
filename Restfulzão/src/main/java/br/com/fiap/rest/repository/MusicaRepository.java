package br.com.fiap.rest.repository;

import br.com.fiap.rest.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica,Integer>{

    public List<Musica> findByNome(String nome);
    public List<Musica> findByDuracao(int nome);

}
