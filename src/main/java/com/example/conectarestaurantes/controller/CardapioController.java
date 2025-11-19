package com.example.conectarestaurantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectarestaurantes.dto.CardapioDTO;
import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.service.CardapioService;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public List<Cardapio> listAll() {
        return cardapioService.getAllCardapios();
    }

    @GetMapping("/{id}")
    public Cardapio findById(@PathVariable Long id) {
        return cardapioService.getCardapioById(id);
    }

    @PostMapping
    public Cardapio create(@RequestBody CardapioDTO cardapioDTO) {
        Cardapio cardapio = new Cardapio();
        cardapio.setNome(cardapioDTO.getNome());
        cardapio.setDescricao(cardapioDTO.getDescricao());
        return cardapioService.createCardapio(cardapio, cardapioDTO.getItensIds());
    }
    
    @PutMapping("/{id}")
    public Cardapio update(@PathVariable Long id, @RequestBody CardapioDTO cardapioDTO) {
        Cardapio cardapio = new Cardapio();
        cardapio.setNome(cardapioDTO.getNome());
        cardapio.setDescricao(cardapioDTO.getDescricao());
        return cardapioService.updateCardapio(id, cardapio, cardapioDTO.getItensIds());
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cardapioService.deleteCardapio(id);
    }
}