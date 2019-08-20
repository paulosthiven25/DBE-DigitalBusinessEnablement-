package br.com.fiap.rest.repository;

import br.com.fiap.rest.entity.Banda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandaRepository extends JpaRepository<Banda,Integer> {
}
