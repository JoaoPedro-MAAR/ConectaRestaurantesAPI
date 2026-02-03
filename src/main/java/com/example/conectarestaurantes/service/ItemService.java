package com.example.conectarestaurantes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.conectarestaurantes.Repository.ItemRepository;
import com.example.conectarestaurantes.model.Item;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    public Page<Item> listarItensPaginado(String nome, Pageable pageable) {
        if (nome == null || nome.isBlank()) {
            return itemRepo.findAll(pageable);
        } 
        return itemRepo.findByNomeContainingIgnoreCase(nome, pageable);
    }

    public List<Item> listarTodos() {
        return itemRepo.findAll();
    }
    
    public List<Item> listarPratosFeitos() {
        return itemRepo.findAll().stream()
                .filter(item -> Boolean.TRUE.equals(item.getIsPratoFeito()))
                .collect(Collectors.toList());
    }

    public Item buscarPorId(Long id) {
        return itemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com ID: " + id));
    }

    @Transactional
    public Item salvar(Item item) {
        return itemRepo.save(item);
    }

    @Transactional
    public Item salvarPratoFeito(Item prato, List<Long> idsComposicao) {
        prato.setIsPratoFeito(true);
        prato.setCategoria("Prato Feito"); 
        
        if (idsComposicao != null && !idsComposicao.isEmpty()) {
            List<Item> itensComposicao = itemRepo.findAllById(idsComposicao);
            prato.setComposicao(itensComposicao);
        }
        
        return itemRepo.save(prato);
    }

    @Transactional
    public Item atualizar(Long id, Item itemAtualizado) {
        Item itemExistente = buscarPorId(id);
        itemExistente.setNome(itemAtualizado.getNome());
        itemExistente.setCategoria(itemAtualizado.getCategoria());
      
        if(itemAtualizado.getComposicao() != null) {
             itemExistente.setComposicao(itemAtualizado.getComposicao());
        }
        return itemRepo.save(itemExistente);
    }

    @Transactional
    public void deletar(Long id) {
        if (!itemRepo.existsById(id)) {
            throw new RuntimeException("Item não encontrado.");
        }
        itemRepo.deleteById(id);
    }
}