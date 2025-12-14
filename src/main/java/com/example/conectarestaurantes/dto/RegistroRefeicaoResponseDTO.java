package com.example.conectarestaurantes.dto;

import java.time.LocalDateTime;

import com.example.conectarestaurantes.model.enums.Turno;

import lombok.Data;

@Data
public class RegistroRefeicaoResponseDTO {
    private Long id;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String nome; 
    private Turno turno;
    private LocalDateTime dataHora;
}