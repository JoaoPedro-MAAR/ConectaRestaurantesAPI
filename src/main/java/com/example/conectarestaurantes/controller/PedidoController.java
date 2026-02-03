package com.example.conectarestaurantes.controller;

import com.example.conectarestaurantes.dto.PedidoCompletoDTO;
import com.example.conectarestaurantes.model.Pedido;
import com.example.conectarestaurantes.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
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
    public ResponseEntity<Page<Pedido>> getPedidosPorSolicitacao(
            @PathVariable Long idSolicitacao,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Pedido> pedidos = pedidoService.buscarPorSolicitacao(idSolicitacao, pageable);
        return ResponseEntity.ok(pedidos);
    }
}