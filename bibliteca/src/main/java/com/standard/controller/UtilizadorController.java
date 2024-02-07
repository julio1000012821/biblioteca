package com.standard.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.standard.dto.UtilizadorDto;
import com.standard.entidade.Utilizador;
import com.standard.service.UtilizadorService;

@RestController
@CrossOrigin(origins ="*", maxAge = 3600)
@RequestMapping("/utilizadores")
//@Scope("prototype")
public class UtilizadorController {
	
	@Autowired
	private UtilizadorService service;
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Utilizador>> listar(){
				
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("{id}")
	public  ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id){
				
		Optional<Utilizador> utilizadores = service.findByIdUtilizador(id);

		if(utilizadores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		
		Utilizador modelo = utilizadores.get();			
		
		return ResponseEntity.status(HttpStatus.OK).body(modelo);	
	}
		
	@PostMapping("/registar")
	public ResponseEntity<Object> save(@RequestBody @Valid UtilizadorDto modelo){
		
		var utilizador = new Utilizador();
		BeanUtils.copyProperties(modelo, utilizador);
		
		// salva o utilizador e retorna um objecto do tipo utilizador
		return ResponseEntity.status(HttpStatus.OK).body(service.save(utilizador));		
	}
	
	
	@DeleteMapping("/remover")
	public  ResponseEntity<Object> delete(@RequestParam Integer id){
				
		Optional<Utilizador> utilizadores = service.findByIdUtilizador(id);

		if(utilizadores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Este utilizador não existe!");
		}
		
		service.delete(utilizadores.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Registo removido com sucesso");	
	}

}
