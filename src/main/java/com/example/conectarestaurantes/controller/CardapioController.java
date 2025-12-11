package com.example.conectarestaurantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectarestaurantes.dto.CardapioDTO;
import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.model.enums.Turno;
import com.example.conectarestaurantes.service.CardapioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menu")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public Page<Cardapio> listAllPaginated(@PageableDefault(page=0, size=10,sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return cardapioService.getAllPaginated(pageable);
    }

    @GetMapping("/all")
    public List<Cardapio> listAll() {
        return cardapioService.getAllCardapios();
    }

    @GetMapping("/{id}")
    public Cardapio findById(@PathVariable Long id) {
        return cardapioService.getCardapioById(id);
    }

    @PostMapping
    public Cardapio create(@RequestBody CardapioDTO cardapioDTO) {
        return cardapioService.createCardapio(cardapioDTO);
        // Cardapio cardapio = new Cardapio();
        // cardapio.setNome(cardapioDTO.getNome());
        // cardapio.setDescricao(cardapioDTO.getDescricao());
        // return cardapioService.createCardapio(cardapio, cardapioDTO.getItensIds());
    }
    

    // Alterar forma de editar depois
    // @PutMapping("/{id}")
    // public Cardapio update(@PathVariable Long id, @RequestBody CardapioDTO cardapioDTO) {
    //     Cardapio cardapio = new Cardapio();
    //     cardapio.setNome(cardapioDTO.getNome());
    //     cardapio.setDescricao(cardapioDTO.getDescricao());
    //     return cardapioService.updateCardapio(id, cardapio, cardapioDTO.getItensIds());
    // }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cardapioService.deleteCardapio(id);
    }

    @PutMapping("/active/{id}")
    public Cardapio activate(@PathVariable Long id){
        return cardapioService.activateCardapio(id);
    }

    @PutMapping("/deactivate")
    public Cardapio deactivate() throws Exception {
        return cardapioService.deactivateCardapio();
    }

    @GetMapping("/active")
    public Cardapio getActive(){
        return cardapioService.getCardapioActive();
    }

    @PutMapping("/{id}/padrao")
    public ResponseEntity<Cardapio> definirCardapioPadrao(@PathVariable Long id, @RequestParam Turno turno) {
        Cardapio cardapioAtualizado = cardapioService.definirCardapioPadrao(id, turno);
        return ResponseEntity.ok(cardapioAtualizado);
    }

    @DeleteMapping("/{id}/padrao")
    public ResponseEntity<Cardapio> removerCardapioPadrao(@PathVariable Long id) {
        Cardapio cardapioAtualizado = cardapioService.removerCardapioPadrao(id);
        return ResponseEntity.ok(cardapioAtualizado);
    }
}