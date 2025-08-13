package com.example.conectarestaurantes.service;


import com.example.conectarestaurantes.Repository.OrderRepository;
import com.example.conectarestaurantes.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRService {


    private final OrderRepository repository;




    public CRService(OrderRepository repository){
        this.repository = repository;
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findbyid(Long id){
        return repository.findById(id).orElse(null);
    }


}
