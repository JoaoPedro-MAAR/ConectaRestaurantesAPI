package com.example.conectarestaurantes.controller;


import com.example.conectarestaurantes.model.Order;
import com.example.conectarestaurantes.service.CRService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class CRController {
    private final CRService service;


    public CRController(CRService y){
        this.service = y;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        System.out.println("Criando um novo order");
        System.out.println(order);
        Order savedBook = service.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newStatus = updates.get("status");

        if (newStatus == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Order updatedOrder = service.updateOrderStatus(id, newStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) { 
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public Page<Order> findAll( @RequestParam(required = false) Long id,
                                @RequestParam(name = "obra_like", required = false) String obra,
                                @RequestParam(name = "gestor_like", required = false) String gestor,
                                @RequestParam(required = false) String status,
                                @RequestParam(name = "qtd_Marmitas_gte", required = false) Integer maiorQue,
                                @RequestParam(name = "qtd_Marmitas_lte", required = false) Integer menorQue,
                                Pageable pageable){
        return service.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
    }

    @GetMapping("/search")
    public Page<Order> search(
            @RequestParam(required = false) Long id,
            @RequestParam(name = "obra_like", required = false) String obra,
            @RequestParam(name = "gestor_like", required = false) String gestor,
            @RequestParam(required = false) String status,
            @RequestParam(name = "qtd_Marmitas_gte", required = false) Integer maiorQue,
            @RequestParam(name = "qtd_Marmitas_lte", required = false) Integer menorQue,
            Pageable pageable) {

        return service.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
}

    @GetMapping("/{id}")
    public Order findById(@PathVariable  Long id){
        return service.findbyid(id);
    }

}
