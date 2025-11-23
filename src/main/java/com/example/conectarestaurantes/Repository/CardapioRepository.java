package com.example.conectarestaurantes.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conectarestaurantes.model.Cardapio;

import java.util.Optional;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>{
   Cardapio findByAtivoTrue();

}