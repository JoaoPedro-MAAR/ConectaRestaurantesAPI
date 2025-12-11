package com.example.conectarestaurantes.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="tb_categoria_cardapio")
public class CategoriaCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer limiteMaximoEscolhas;

    @ManyToOne
    @JoinColumn(name="cardapio_id")
    @ToString.Exclude
    @JsonIgnore
    private Cardapio cardapio;

    @ManyToMany
    @JoinTable(
        name = "tb_categoria_item",
        joinColumns = @JoinColumn(name = "categoria_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itens = new ArrayList<>();
}
