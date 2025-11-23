package com.example.conectarestaurantes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.conectarestaurantes.model.Item;
import com.example.conectarestaurantes.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Page<Item> listarItens(@RequestParam(required = false) String nome, Pageable pageable) {
        System.out.println("Foi chamado");
        System.out.println(itemService.listarItens(nome,pageable));
        return itemService.listarItens(nome, pageable);
    }   

}
