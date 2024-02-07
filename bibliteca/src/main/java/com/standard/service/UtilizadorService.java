package com.standard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.standard.entidade.Utilizador;
import com.standard.repository.UtilizadorRepository;

// para uma classe ser do tipo service deve ter a anotação @Service
@Service
public class UtilizadorService {

	@Autowired
	private UtilizadorRepository repository;
	
	// permite inserir e alterar um determinado registo na tabela utilizador
	public Utilizador save(Utilizador model) {
		
		return repository.save(model);
	}
	
	// devolve uma lista de utilizadores
	public List<Utilizador> findAll(){
		
		return repository.findAll();
	}
	
	// devolve um registo em função do id do utilizador
	public Optional<Utilizador> findByIdUtilizador(Integer id){
		
		return repository.findById(id);
	}
	
	// remove um utilizador, no modelo temos de passar obrigatóriamente o id
	public void delete(Utilizador model) {
		
		repository.delete(model);
	}
	
	
	
	
}
