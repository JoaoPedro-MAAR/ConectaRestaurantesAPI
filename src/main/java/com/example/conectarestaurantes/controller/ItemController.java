package com.example.conectarestaurantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.conectarestaurantes.model.Item;
import com.example.conectarestaurantes.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    public static class PratoFeitoDTO {
        public String nome;
        public List<Long> itensIds;
    }

    @GetMapping
    public ResponseEntity<Page<Item>> listarItens(
            @RequestParam(required = false) String nome, 
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(itemService.listarItensPaginado(nome, pageable));
    }   

    @GetMapping("/all")
    public ResponseEntity<List<Item>> listarTodos() {
        return ResponseEntity.ok(itemService.listarTodos());
    }
    
    // NOVO: Endpoint para listar pratos feitos
    @GetMapping("/pratos-feitos")
    public ResponseEntity<List<Item>> listarPratosFeitos() {
        return ResponseEntity.ok(itemService.listarPratosFeitos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Item> criar(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.salvar(item));
    }
    @PostMapping("/prato-feito")
    public ResponseEntity<Item> criarPratoFeito(@RequestBody PratoFeitoDTO dto) {
        Item prato = new Item();
        prato.setNome(dto.nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.salvarPratoFeito(prato, dto.itensIds));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item item) {
        return ResponseEntity.ok(itemService.atualizar(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}