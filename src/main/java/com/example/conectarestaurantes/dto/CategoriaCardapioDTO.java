package com.example.conectarestaurantes.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoriaCardapioDTO {
    private String nome;
    private Integer limiteMaximoEscolhas;
    private List<Long> itensIds;
}
