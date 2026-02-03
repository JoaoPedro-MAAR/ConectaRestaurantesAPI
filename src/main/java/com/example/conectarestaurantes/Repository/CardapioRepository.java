package com.example.conectarestaurantes.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.model.enums.DiaSemana;
import com.example.conectarestaurantes.model.enums.Turno;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>{
   Cardapio findByAtivoTrue();


   Optional<Cardapio> findByTurnoPadrao(Turno turno);

   List<Cardapio> findByDiaSemana(DiaSemana diaSemana);

   @Query(value = """
   SELECT * FROM tb_cardapio c 
   WHERE (:nome IS NULL OR LOWER(CAST(c.nome as TEXT)) LIKE LOWER(CONCAT('%', :nome, '%')))
   AND (:descricao IS NULL OR LOWER(CAST(c.descricao as TEXT)) LIKE LOWER(CONCAT('%', :descricao, '%')))
   AND (:ativo IS NULL OR c.ativo = :ativo)
   AND (:turnoPadrao IS NULL OR c.turno_padrao = :turnoPadrao)
         """, nativeQuery = true)
   Page<Cardapio> findAllPaginateWithFilters(Pageable pageable, 
         @Param("nome") String nome,
         @Param("descricao") String descricao,
         @Param("ativo") Boolean ativo,
         @Param("turnoPadrao") String turnoPadrao
         );
}