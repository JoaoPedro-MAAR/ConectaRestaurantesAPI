package com.example.conectarestaurantes.controller;


import com.example.conectarestaurantes.model.Order;
import com.example.conectarestaurantes.service.CRService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public List<Order> findAll(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    public Order findById(@PathVariable  Long id){
        return service.findbyid(id);
    }

}
