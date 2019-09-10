package br.com.fiap.fiaphotel.repository;

import br.com.fiap.fiaphotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
