package com.example.conectarestaurantes.dto;

import java.util.List;

import lombok.Data;

@Data
public class CardapioDTO {
    private String nome;
    private String descricao;
    private List<Long> itensIds;
}
