package com.example.conectarestaurantes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String status;


    @ManyToMany
    @JoinTable(
            name = "tb_pedidos_itens",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "itens_id")
    )
    private List<Item> itens;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private Solicitacao solicitacao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario solicitante;

    @Column
    private String observacao;

}