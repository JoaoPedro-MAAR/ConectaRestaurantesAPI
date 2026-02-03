package com.example.conectarestaurantes.Repository;

import com.example.conectarestaurantes.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findBySolicitacaoId(Integer idSolicitacao);

}
