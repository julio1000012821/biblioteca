/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.standard.biblioteca.dao;

import com.standard.biblioteca.config.Conexao_DB;
import com.standard.biblioteca.entidades.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juliosilva
 */

public class UtilizadorDAO {
    
    Connection conexao;
    
    public UtilizadorDAO(){
        conexao = new Conexao_DB().getConnection();
    }

    
    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public int create(Utilizador model) 
    {
        
        try 
        {
            Connection connection = this.conexao;
            String sql= "insert into utilizador(nome, senha, email) values(?, ?,?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getNome());
            ps.setString(2, model.getSenha());
            ps.setString(3, model.getEmail());
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return 0;
    }
    
    public List<Utilizador> findAll() 
    {
        List<Utilizador> lista = null;
        
        try 
        {
            Connection connection = this.conexao;
            String sql= "select id_utilizador, nome, email from utilizador";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            lista = new ArrayList<>();
            while(result.next()){
               
               Utilizador user = new Utilizador();
               user.setIdUtilizador(result.getInt(1));
               user.setNome(result.getString(2));
               user.setEmail(result.getString(3));
               lista.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    
    
    
    
    public int update(Utilizador model) 
    {
        
        try 
        {
            Connection connection = this.conexao;
            String sql= "insert into utilizador(id_utilizador, nome, senha, email) values(?, ?,?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, model.getNome());
            ps.setString(2, model.getSenha());
            ps.setString(3, model.getEmail());
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        return 0;
    }
    
    
    
}
