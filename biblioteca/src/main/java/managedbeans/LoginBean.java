/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbeans;

import com.google.gson.Gson;
import com.standard.biblioteca.config.Api;
import com.standard.biblioteca.entidades.Utilizador;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juliosilva
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    Utilizador utilizador;

    public LoginBean() {
    }
    
    @PostConstruct
    public void init(){
       utilizador = new Utilizador(); 
    }
    
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
    private boolean validarUtilizador() throws ProtocolException, IOException{
                
        Gson gson = Api.getGson("http://localhost/utilizadores/login?nome=" + utilizador.getNome() + "&senha=" + utilizador.getSenha());
        if(gson != null){
            utilizador = gson.fromJson(Api.reader, Utilizador.class);  
        }
        
        return utilizador != null;
    }
    

    
    
    
    public void fazerlogin(){
     
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            if(validarUtilizador()){
                
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
                session.setAttribute("utilizador", utilizador);
                FacesContext.getCurrentInstance().getExternalContext().redirect("listar_utilizadores.xhtml");
            }
            else
            {
                System.err.println("Utilizador não existe");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(UtilizadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
