package com.example.conectarestaurantes.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.conectarestaurantes.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findByNomeItemContainingIgnoreCase(String nome, Pageable pageable);

}