package com.example.conectarestaurantes.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.conectarestaurantes.Repository.ItemRepository;
import com.example.conectarestaurantes.model.Item;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    public Page<Item> listarItens(String nome, Pageable pageable) {
        if (nome == null || nome.isBlank()) {
            return itemRepo.findAll(pageable);
        } 
        
        return itemRepo.findByNomeItemContainingIgnoreCase(nome, pageable);
    }
}
