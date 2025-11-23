package com.example.conectarestaurantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Cardapio> getAllPaginated(Pageable pageable) {
        return cardapioRepo.findAll(pageable);
    }

    public Cardapio activateCardapio(Long id) {
        Cardapio cardapioativoAtual = getCardapioActive();
        Cardapio newCandidate = getCardapioById(id);
        if (cardapioativoAtual == null){
            newCandidate.setAtivo(true);
            cardapioRepo.save(newCandidate);
            return newCandidate;
        }
        cardapioativoAtual.setAtivo(false);
        newCandidate.setAtivo(true);
        cardapioRepo.save(cardapioativoAtual);
        cardapioRepo.save(newCandidate);
        return newCandidate;

    }

    public Cardapio getCardapioActive() {
        return cardapioRepo.findByAtivoTrue();
    }

    public Cardapio deactivateCardapio() throws Exception {
        Cardapio newCandidate = cardapioRepo.findByAtivoTrue();
        if (newCandidate == null){
            throw new Exception("Cardapio inexsistente");
        }
        newCandidate.setAtivo(false);
        cardapioRepo.save(newCandidate);
        return newCandidate;


    }
}
