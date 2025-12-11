package com.example.conectarestaurantes.controller;

import com.example.conectarestaurantes.dto.CardapioDTO;
import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import java.util.List;

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

}