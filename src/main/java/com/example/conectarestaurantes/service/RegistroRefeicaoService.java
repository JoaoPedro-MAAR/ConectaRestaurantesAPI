package com.example.conectarestaurantes.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.conectarestaurantes.Repository.FuncionarioRepository;
import com.example.conectarestaurantes.Repository.RegistroRefeicaoRepository;
import com.example.conectarestaurantes.dto.RegistroRefeicaoDTO;
import com.example.conectarestaurantes.dto.RegistroRefeicaoResponseDTO;
import com.example.conectarestaurantes.model.Funcionario;
import com.example.conectarestaurantes.model.RegistroRefeicao;

@Service
public class RegistroRefeicaoService {

    @Autowired
    private RegistroRefeicaoRepository registroRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    public RegistroRefeicaoResponseDTO buscarFuncionarioPorCpf(String cpf) {
       
        String cpfLimpo = cpf.replaceAll("\\D", ""); 
        
        Funcionario funcionario = funcionarioRepo.findByCpf(cpfLimpo)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com este CPF."));

        return converterParaDTO(funcionario, null); 
    }

   
    public RegistroRefeicaoResponseDTO registrarRefeicao(RegistroRefeicaoDTO dto) {
        String cpfLimpo = dto.getCpfFuncionario().replaceAll("\\D", "");

        Funcionario funcionario = funcionarioRepo.findByCpf(cpfLimpo)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));

       

        RegistroRefeicao registro = new RegistroRefeicao();
        registro.setDataHora(LocalDateTime.now());
        registro.setTurno(dto.getTurno());
        registro.setFuncionario(funcionario);
        
       
        registro.setEmpresa(funcionario.getEmpresa()); 

        RegistroRefeicao salvo = registroRepo.save(registro);

        return converterParaDTO(funcionario, salvo);
    }

   
    private RegistroRefeicaoResponseDTO converterParaDTO(Funcionario f, RegistroRefeicao r) {
        RegistroRefeicaoResponseDTO resp = new RegistroRefeicaoResponseDTO();
        resp.setNomeFuncionario(f.getNome());
        resp.setCpfFuncionario(f.getCpf());
        
       
        if (f.getEmpresa() != null) {
            resp.setNome(f.getEmpresa().getNome()); 
        }

        if (r != null) {
            resp.setId(r.getId());
            resp.setTurno(r.getTurno());
            resp.setDataHora(r.getDataHora());
        }
        return resp;
    }
}