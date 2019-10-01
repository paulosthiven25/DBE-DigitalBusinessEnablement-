package com.fiap.demo.repository;

import com.fiap.demo.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {


}
