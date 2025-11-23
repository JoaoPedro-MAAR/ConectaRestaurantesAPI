package com.example.conectarestaurantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.conectarestaurantes.dto.CardapioDTO;
import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.service.CardapioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menu")
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