package com.standard.entidade;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="utilizador")

public class Utilizador implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilizador")
    private Integer idUtilizador;
    @Basic(optional = false)
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha")
    private String senha;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    
    
    public Utilizador() {
    	
    }

	public Integer getIdUtilizador() {
		return idUtilizador;
	}

	public void setIdUtilizador(Integer idUtilizador) {
		this.idUtilizador = idUtilizador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
