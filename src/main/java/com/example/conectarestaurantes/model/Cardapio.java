package com.example.conectarestaurantes.model;

import java.util.ArrayList;
import java.util.List;

import com.example.conectarestaurantes.model.enums.DiaSemana;
import com.example.conectarestaurantes.model.enums.Turno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @Column(length = 500, nullable = true)
    private String descricao;

    @Column(nullable=true)
    private Boolean ativo;

    @OneToMany(mappedBy = "cardapio", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<CategoriaCardapio> categorias = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Turno turnoPadrao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private DiaSemana diaSemana;
}
