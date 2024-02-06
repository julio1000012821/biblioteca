/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.standard.biblioteca.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliosilva
 */
public class Conexao_DB {
    
    private Connection connection;
    private static final String USER = "root";
    private static final String PASSWORD = "mirempet#2022";
    private static final String IP = "localhost";
    
    public Conexao_DB() 
    {
        // chama o construtor com paramatros
        this("jdbc:mysql://"+ IP +":3306", "db_biblioteca_sb");
    }
    
   public Conexao_DB(String url, String database){
      
        try {
            
            createConnection(url, database);
            //this.creampi
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }
   
   
   public void createConnection(String url, String database) throws SQLException{
       try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            connection = (Connection) java.sql.DriverManager.getConnection(url + "/" + database, USER, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
   }
   
    public  Connection getConnection() {
        return connection;
    }

    public  void setConnection(Connection connection) {
        this.connection = connection;
    }  
    
}
