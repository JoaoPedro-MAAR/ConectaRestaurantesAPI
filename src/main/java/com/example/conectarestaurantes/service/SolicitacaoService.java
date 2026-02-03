package com.example.conectarestaurantes.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.conectarestaurantes.Repository.SolicitacaoRepository;
import com.example.conectarestaurantes.model.Solicitacao;


@Service
public class SolicitacaoService {


  private final SolicitacaoRepository repository;
  
    public Solicitacao updateOrderStatus(Long orderId, String newStatusString) {

        Solicitacao order = repository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + orderId));
        
        order.setStatus(newStatusString);
        return repository.save(order);
    }

    public Page<Solicitacao> search(Long id, String obra, String gestor, String status, Integer maiorQue, Integer menorQue, Pageable pageable) {
        return repository.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
    }


    public SolicitacaoService(SolicitacaoRepository repository){
        this.repository = repository;
    }

    public Page<Solicitacao> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Solicitacao findbyid(Long id){
        return repository.findById(id).orElse(null);
    }

    public Solicitacao save(Solicitacao o){
        o.setStatus("RECEBIDO");
        return repository.save(o);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
