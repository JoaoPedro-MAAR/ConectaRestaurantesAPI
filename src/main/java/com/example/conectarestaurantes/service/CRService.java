package com.example.conectarestaurantes.service;


import com.example.conectarestaurantes.Repository.OrderRepository;
import com.example.conectarestaurantes.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class CRService {


  private final OrderRepository repository;
  
    public Order updateOrderStatus(Long orderId, String newStatusString) {

        Order order = repository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + orderId));
        
        order.setStatus(newStatusString);
        return repository.save(order);
    }

    public Page<Order> search(Long id, String obra, String gestor, String status, Integer maiorQue, Integer menorQue, Pageable pageable) {
        return repository.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
    }


    public CRService(OrderRepository repository){
        this.repository = repository;
    }

    public Page<Order> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Order findbyid(Long id){
        return repository.findById(id).orElse(null);
    }

    public Order save(Order o){
        o.setStatus("RECEBIDO");
        return repository.save(o);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
