package com.example.conectarestaurantes.service;

import com.example.conectarestaurantes.Repository.FuncionarioRepository;
import com.example.conectarestaurantes.Repository.ItemRepository;
import com.example.conectarestaurantes.Repository.PedidoRepository;
import com.example.conectarestaurantes.Repository.SolicitacaoRepository;
import com.example.conectarestaurantes.dto.PedidoCompletoDTO;
import com.example.conectarestaurantes.model.Funcionario;
import com.example.conectarestaurantes.model.Pedido;

import com.example.conectarestaurantes.model.Solicitacao;
import com.example.conectarestaurantes.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Pedido> pedidosPorSolicitacao(Integer idSolicitacao){
        return repository.findBySolicitacaoId(idSolicitacao);
    }




    public Pedido save(PedidoCompletoDTO dto) {

        Solicitacao solicitacao = solicitacaoRepository.findById(dto.solicitacao_id)
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        Funcionario solicitante = funcionarioRepository.findById(dto.solicitante_id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Pedido novoPedido = new Pedido();
        novoPedido.setStatus("ABERTO");
        novoPedido.setObservacao(dto.observacao);
        novoPedido.setSolicitacao(solicitacao);
        novoPedido.setSolicitante(solicitante);

        if (dto.itens != null && !dto.itens.isEmpty()) {
            List<Long> idsDosItens = dto.itens.stream()
                    .map(itemDto -> itemDto.id)
                    .toList();

            List<Item> itensReais = itemRepository.findAllById(idsDosItens);

            if (itensReais.size() != idsDosItens.size()) {
                throw new RuntimeException("Algum ID de item enviado não existe no banco!");
            }

            novoPedido.setItens(itensReais);
        }

        return pedidoRepository.save(novoPedido);
    }


    public Optional<Pedido> findById(Long id){
       return repository.findById(id);
    }


}
