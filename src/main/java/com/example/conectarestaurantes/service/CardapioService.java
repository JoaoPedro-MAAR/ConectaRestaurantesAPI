package com.example.conectarestaurantes.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.conectarestaurantes.Repository.CardapioRepository;
import com.example.conectarestaurantes.Repository.ItemRepository;
import com.example.conectarestaurantes.dto.CardapioDTO;
import com.example.conectarestaurantes.dto.CategoriaCardapioDTO;
import com.example.conectarestaurantes.model.Cardapio;
import com.example.conectarestaurantes.model.CategoriaCardapio;
import com.example.conectarestaurantes.model.Item;
import com.example.conectarestaurantes.model.enums.DiaSemana;
import com.example.conectarestaurantes.model.enums.Turno;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepo;

    @Autowired
    private ItemRepository itemRepo;

    public List<Cardapio> getAllCardapios() {
        return cardapioRepo.findAll();
    }

    public Cardapio getCardapioById(Long id) {
        return cardapioRepo.findById(id).orElse(null);
    }

    @Transactional
    public Cardapio createCardapio(CardapioDTO cardapioDTO) {
        Cardapio cardapio = new Cardapio();
        cardapio.setNome(cardapioDTO.getNome());
        cardapio.setDescricao(cardapioDTO.getDescricao());
        cardapio.setDiaSemana(DiaSemana.fromString(cardapioDTO.getDiaSemana()));
        
        if (cardapioDTO.getAtivo() == null){
            cardapio.setAtivo(false);
        } else {
            cardapio.setAtivo(cardapioDTO.getAtivo());
        }

        if (cardapioDTO.getCategorias () != null){
            for (CategoriaCardapioDTO categoriaDTO : cardapioDTO.getCategorias()){
                CategoriaCardapio categoria = new CategoriaCardapio();

                categoria.setNome(categoriaDTO.getNome());
                categoria.setLimiteMaximoEscolhas(categoriaDTO.getLimiteMaximoEscolhas());
                categoria.setCardapio(cardapio);

                if (categoriaDTO.getItensIds() != null && !categoriaDTO.getItensIds().isEmpty()) {
                    List<Item> itens = itemRepo.findAllById(categoriaDTO.getItensIds());
                    categoria.setItens(itens);
                }
                cardapio.getCategorias().add(categoria);
            }
        }
        return cardapioRepo.save(cardapio);
    }

    public void deleteCardapio(Long id) {
        cardapioRepo.deleteById(id);
    }

    // public Cardapio updateCardapio(Long id, Cardapio cardapio, List<Long> itensIds) {
    //     Cardapio cardapioAtual = getCardapioById(id);
    //     if (cardapioAtual == null) {
    //         return null;
    //     }

    //     cardapioAtual.setNome(cardapio.getNome());
    //     cardapioAtual.setDescricao(cardapio.getDescricao());
    //     if (itensIds != null) {
    //         cardapioAtual.setItens(itemRepo.findAllById(itensIds));
    //     }
    //     return cardapioRepo.save(cardapioAtual);
    // }

    public Page<Cardapio> getAllPaginated(Pageable pageable, String nome, String descricao, Boolean ativo, String turnoPadrao) {
        return cardapioRepo.findAllPaginateWithFilters(pageable, nome, descricao, ativo, turnoPadrao);
    }

    public Cardapio activateCardapio(Long id) {
        Cardapio cardapioativoAtual = getCardapioActive();
        Cardapio newCandidate = getCardapioById(id);
        if (cardapioativoAtual == null){
            newCandidate.setAtivo(true);
            cardapioRepo.save(newCandidate);
            return newCandidate;
        }
        cardapioativoAtual.setAtivo(false);
        newCandidate.setAtivo(true);
        cardapioRepo.save(cardapioativoAtual);
        cardapioRepo.save(newCandidate);
        return newCandidate;

    }

    public Cardapio getCardapioActive() {
        return cardapioRepo.findByAtivoTrue();
    }

    public Cardapio deactivateCardapio() throws Exception {
        Cardapio newCandidate = cardapioRepo.findByAtivoTrue();
        if (newCandidate == null){
            throw new Exception("Cardapio inexsistente");
        }
        newCandidate.setAtivo(false);
        cardapioRepo.save(newCandidate);
        return newCandidate;


    }

    public Cardapio definirCardapioPadrao (Long idCardapio, Turno turno) {
        Optional<Cardapio> cardapioAntigoPadrao = cardapioRepo.findByTurnoPadrao(turno);

        if (cardapioAntigoPadrao.isPresent()) {
            Cardapio antigo = cardapioAntigoPadrao.get();
            antigo.setTurnoPadrao(null);
            cardapioRepo.save(antigo);
        }
        Cardapio novoCardapioPadrao = getCardapioById(idCardapio);
        novoCardapioPadrao.setTurnoPadrao(turno);
        return cardapioRepo.save(novoCardapioPadrao);
    }

    public Cardapio removerCardapioPadrao (Long id) {
        Cardapio cardapio = getCardapioById(id);
        cardapio.setTurnoPadrao(null);
        return cardapioRepo.save(cardapio);
    }

    public Cardapio definirDiaSemana(Long idCardapio, String diaSemana) {
        Cardapio cardapio = getCardapioById(idCardapio);
        cardapio.setDiaSemana(DiaSemana.fromString(diaSemana));
        return cardapioRepo.save(cardapio);
    }

    public Cardapio removerDiaSemana(Long id) {
        Cardapio cardapio = getCardapioById(id);
        cardapio.setDiaSemana(null);
        return cardapioRepo.save(cardapio);
    }

    public List<Cardapio> getCardapiosDeHoje() {
        DayOfWeek hoje = LocalDate.now().getDayOfWeek();
        DiaSemana diaSemana = convertDayOfWeekToDiaSemana(hoje);
        return cardapioRepo.findByDiaSemana(diaSemana);
    }

    private DiaSemana convertDayOfWeekToDiaSemana(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> DiaSemana.SEGUNDA;
            case TUESDAY -> DiaSemana.TERCA;
            case WEDNESDAY -> DiaSemana.QUARTA;
            case THURSDAY -> DiaSemana.QUINTA;
            case FRIDAY -> DiaSemana.SEXTA;
            case SATURDAY -> DiaSemana.SABADO;
            case SUNDAY -> DiaSemana.DOMINGO;
        };
    }
}
