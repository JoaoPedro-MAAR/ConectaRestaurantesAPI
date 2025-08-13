package com.example.conectarestaurantes.controller;


import com.example.conectarestaurantes.model.Order;
import com.example.conectarestaurantes.service.CRService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class CRController {
    private final CRService service;


    public CRController(CRService y){
        this.service = y;
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
