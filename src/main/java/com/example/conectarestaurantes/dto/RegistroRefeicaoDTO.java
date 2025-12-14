package com.example.conectarestaurantes.dto;

import com.example.conectarestaurantes.model.enums.Turno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistroRefeicaoDTO {

    @NotBlank(message = "O CPF do funcionário é obrigatório")
    private String cpfFuncionario;

    @NotNull(message = "O turno é obrigatório")
    private Turno turno;
}
