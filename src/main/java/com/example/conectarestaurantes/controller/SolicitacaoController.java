package com.example.conectarestaurantes.controller;


import java.io.IOException;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectarestaurantes.dto.RelatorioDTO;
import com.example.conectarestaurantes.model.Solicitacao;
import com.example.conectarestaurantes.service.SolicitacaoService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class SolicitacaoController {
    private final SolicitacaoService service;


    public SolicitacaoController(SolicitacaoService y){
        this.service = y;
    }

    @PostMapping
    public ResponseEntity<Solicitacao> createOrder(@RequestBody Solicitacao order) {
        System.out.println("Criando um novo order");
        System.out.println(order);
        Solicitacao savedBook = service.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Solicitacao> updateOrderStatus(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newStatus = updates.get("status");

        if (newStatus == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Solicitacao updatedOrder = service.updateOrderStatus(id, newStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) { 
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public Page<Solicitacao> findAll(@RequestParam(required = false) Long id,
                                     @RequestParam(name = "obra_like", required = false) String obra,
                                     @RequestParam(name = "gestor_like", required = false) String gestor,
                                     @RequestParam(required = false) String status,
                                     @RequestParam(name = "qtd_Marmitas_gte", required = false) Integer maiorQue,
                                     @RequestParam(name = "qtd_Marmitas_lte", required = false) Integer menorQue,
                                     @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable){
        return service.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
    }

    @GetMapping("/search")
    public Page<Solicitacao> search(
            @RequestParam(required = false) Long id,
            @RequestParam(name = "obra_like", required = false) String obra,
            @RequestParam(name = "gestor_like", required = false) String gestor,
            @RequestParam(required = false) String status,
            @RequestParam(name = "qtd_Marmitas_gte", required = false) Integer maiorQue,
            @RequestParam(name = "qtd_Marmitas_lte", required = false) Integer menorQue,
            Pageable pageable) {

        return service.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
}

    @GetMapping("/{id}")
    public Solicitacao findById(@PathVariable  Long id){
        return service.findbyid(id);
    }


    @GetMapping("/relatorio/metricas")
    public ResponseEntity<RelatorioDTO> getMetricas() {
        return ResponseEntity.ok(service.gerarMetricas());
    }

    @GetMapping("/relatorio/csv")
    public void exportarCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"relatorio_solicitacoes.csv\"");
        response.setCharacterEncoding("UTF-8");

        service.gerarCsv(response.getWriter());
    }
}
