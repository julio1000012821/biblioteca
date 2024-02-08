/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.standard.biblioteca.entidades;

import java.io.Serializable;

/**
 *
 * @author juliosilva
 */
public class Utilizador implements Serializable{
    
   private static final long serialVersionUID = 1L;
   private int idUtilizador;
   private String nome;
   private String senha;
   private String email;

    public Utilizador() {
    
    }
   
    public Utilizador(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
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

    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", senha=" + senha + '}';
    }
}
