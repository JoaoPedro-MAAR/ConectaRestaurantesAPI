package com.example.conectarestaurantes.dto;

import com.example.conectarestaurantes.model.Item;

import java.util.List;

public class PedidoCompletoDTO {
    public Long solicitante_id;
    public Long solicitacao_id;
    public List<ItemOnlyId> itens;
    public String observacao;

}
