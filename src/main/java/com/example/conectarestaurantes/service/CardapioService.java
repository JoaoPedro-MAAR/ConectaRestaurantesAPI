package com.example.conectarestaurantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.conectarestaurantes.Repository.CardapioRepository;
import com.example.conectarestaurantes.Repository.ItemRepository;
import com.example.conectarestaurantes.model.Cardapio;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepo;

    @Autowired
    private ItemRepository itemRepo;

    public List<Cardapio> getAllCardapios() {
        return cardapioRepo.findAll();
    }

    public Cardapio getCardapioById(Long id) {
        return cardapioRepo.findById(id).orElse(null);
    }

    public Cardapio createCardapio(Cardapio cardapio, List<Long> itensIds) {
        if (itensIds != null && !itensIds.isEmpty()) {
            cardapio.setItens(itemRepo.findAllById(itensIds));
        }
        return cardapioRepo.save(cardapio);
    }

    public void deleteCardapio(Long id) {
        cardapioRepo.deleteById(id);
    }

    public Cardapio updateCardapio(Long id, Cardapio cardapio, List<Long> itensIds) {
        Cardapio cardapioAtual = getCardapioById(id);
        if (cardapioAtual == null) {
            return null;
        }

        cardapioAtual.setNome(cardapio.getNome());
        cardapioAtual.setDescricao(cardapio.getDescricao());
        if (itensIds != null) {
            cardapioAtual.setItens(itemRepo.findAllById(itensIds));
        }
        return cardapioRepo.save(cardapioAtual);
    } 

}
