package com.example.conectarestaurantes.dto;

import java.util.Map;

public record RelatorioDTO(
    long totalSolicitacoes,
    long totalMarmitas,
    Map<String, Long> pedidosPorStatus
) {}