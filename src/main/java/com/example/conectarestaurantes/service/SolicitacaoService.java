package com.example.conectarestaurantes.service;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.conectarestaurantes.Repository.SolicitacaoRepository;
import com.example.conectarestaurantes.dto.RelatorioDTO;
import com.example.conectarestaurantes.model.Solicitacao;


@Service
public class SolicitacaoService {


  private final SolicitacaoRepository repository;
  
    public Solicitacao updateOrderStatus(Long orderId, String newStatusString) {

        Solicitacao order = repository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + orderId));
        
        order.setStatus(newStatusString);
        return repository.save(order);
    }

    public Page<Solicitacao> search(Long id, String obra, String gestor, String status, Integer maiorQue, Integer menorQue, Pageable pageable) {
        return repository.search(id, obra, gestor, status, maiorQue, menorQue, pageable);
    }


    public SolicitacaoService(SolicitacaoRepository repository){
        this.repository = repository;
    }

    public Page<Solicitacao> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Solicitacao findbyid(Long id){
        return repository.findById(id).orElse(null);
    }

    public Solicitacao save(Solicitacao o){
        o.setStatus("RECEBIDO");
        return repository.save(o);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public RelatorioDTO gerarMetricas() {
        List<Solicitacao> todas = repository.findAll();

        long totalSolicitacoes = todas.size();
        
        long totalMarmitas = todas.stream()
                .mapToInt(Solicitacao::getQtd_Marmitas)
                .sum();

        Map<String, Long> porStatus = todas.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getStatus() != null ? s.getStatus() : "SEM STATUS",
                        Collectors.counting()
                ));

        return new RelatorioDTO(totalSolicitacoes, totalMarmitas, porStatus);
    }

    public void gerarCsv(PrintWriter writer) {
        List<Solicitacao> solicitacoes = repository.findAll();
        
        // Cabeçalho do CSV
        writer.println("ID,Obra,Gestor,Qtd Marmitas,Status");

        for (Solicitacao s : solicitacoes) {
            writer.printf("%d,%s,%s,%d,%s\n",
                    s.getId(),
                    escapeCsv(s.getObra()),
                    escapeCsv(s.getGestor()),
                    s.getQtd_Marmitas(),
                    escapeCsv(s.getStatus())
            );
        }
    }

    private String escapeCsv(String data) {
        if (data == null) return "";
        if (data.contains(",") || data.contains("\n")) {
            return "\"" + data.replace("\"", "\"\"") + "\"";
        }
        return data;
    }


}
