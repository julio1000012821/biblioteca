package com.standard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.standard.entidade.Utilizador;

public interface UtilizadorRepository extends JpaRepository<Utilizador,Integer>{
    
}
