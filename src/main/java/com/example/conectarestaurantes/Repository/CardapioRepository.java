package com.example.conectarestaurantes.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.model.enums.Turno;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>{
   Cardapio findByAtivoTrue();


   Optional<Cardapio> findByTurnoPadrao(Turno turno);
}