package com.example.conectarestaurantes.controller;

import com.example.conectarestaurantes.dto.PedidoCompletoDTO;
import com.example.conectarestaurantes.model.Pedido;
import com.example.conectarestaurantes.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoCompletoDTO pedido) {

        Pedido novoPedido = pedidoService.save(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.findById(id);

        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/solicitacao/{idSolicitacao}")
    public List<Pedido> getPedidoPelaSolicitacao(@PathVariable Integer idSolicitacao){
        return pedidoService.pedidosPorSolicitacao(idSolicitacao);
    }
}