package com.example.conectarestaurantes.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, columnDefinition = "VARCHAR(50)")
    private String status;

    @Column()
    private List<Item> pedido;



    private Solicitacao solicitacao;



    private Funcionario solicitante;

}
