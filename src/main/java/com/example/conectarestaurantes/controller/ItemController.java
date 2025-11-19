package com.example.conectarestaurantes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectarestaurantes.model.Item;
import com.example.conectarestaurantes.service.ItemService;

@RestController
@RequestMapping("/itens") 
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Page<Item> listarItens(@RequestParam(required = false) String nome, Pageable pageable) {
        return itemService.listarItens(nome, pageable);
    }   

}
