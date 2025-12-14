package com.example.conectarestaurantes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.conectarestaurantes.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
