/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbeans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.standard.biblioteca.config.Api;
import com.standard.biblioteca.entidades.Utilizador;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juliosilva
 */
@Named(value = "utilizadorBean")
@ViewScoped
public class UtilizadorBean implements Serializable {

    /**
     * Creates a new instance of UtilizadorBean
     */
    
    Utilizador utilizador;
    List<Utilizador> itens,listaFiltrada;
    
    
    public UtilizadorBean() {
    
    }
    
    @PostConstruct
    public void init(){
       utilizador = new Utilizador();
       itens = listarUtilizadores();
       listaFiltrada = null;
       
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
    
    public List<Utilizador> listarUtilizadores()
    {
        try 
        {
            Gson gson  = Api.getGson("http://localhost/utilizadores/listar");
            return gson.fromJson(Api.reader, new TypeToken<List<Utilizador>>(){}.getType());
        } 
        catch (ProtocolException ex)
        {
            ex.printStackTrace();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        
        return new ArrayList<>();
    }
}
