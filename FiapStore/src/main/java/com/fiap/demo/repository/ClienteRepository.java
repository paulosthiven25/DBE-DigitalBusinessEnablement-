package com.fiap.demo.repository;

import com.fiap.demo.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    List<Cliente> findByNomeContainsIgnoreCase(String nome);
}
