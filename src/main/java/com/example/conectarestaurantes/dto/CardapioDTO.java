package com.example.conectarestaurantes.dto;

import java.util.List;

import com.example.conectarestaurantes.model.enums.DiaSemana;

import lombok.Data;

@Data
public class CardapioDTO {
    private String nome;
    private String descricao;
    private Boolean ativo;
    private String diaSemana;
    private List<CategoriaCardapioDTO> categorias;
}
