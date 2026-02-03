package com.example.conectarestaurantes.model.enums;

public enum DiaSemana {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO,
    DOMINGO;

    public static DiaSemana fromString(String dia) {
        if (dia == null) {
            return null;
        }
        for (DiaSemana d : DiaSemana.values()) {
            if (d.name().equalsIgnoreCase(dia)) {
                return d;
            }
        }
        throw new IllegalArgumentException("Dia da semana inválido: " + dia);
    }
}
