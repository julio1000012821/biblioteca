package com.standard.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UtilizadorDto {
	
	private Integer idUtilizador;
	
	@NotNull
    private String nome;
	
	@NotNull
	private String email;
    
    @NotNull
    private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIdUtilizador() {
		return idUtilizador;
	}

	public void setIdUtilizador(Integer idUtilizador) {
		this.idUtilizador = idUtilizador;
	}
}
