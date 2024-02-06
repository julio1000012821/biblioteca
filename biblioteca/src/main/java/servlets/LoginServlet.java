/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.standard.biblioteca.config.Conexao_DB;
import com.standard.biblioteca.dao.UtilizadorDAO;
import com.standard.biblioteca.entidades.Utilizador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juliosilva
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet{
     
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private String nome;
     private String senha;
     private String mensagem;
     
     public void init(ServletConfig config) throws ServletException{
         super.init(config);
         mensagem = "";
         
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
     
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String operacao = request.getParameter("operacao");
        nome = request.getParameter("username");
        senha = request.getParameter("senha");
        String email = request.getParameter("email");
        
        
         System.out.println("Nome: " +  nome);
         System.out.println("Senha: " + senha);
         System.out.println("email: " + email);
         System.out.println("operacao: " + operacao);
         
         if(operacao.equals("criar_conta")){

            UtilizadorDAO dao = new UtilizadorDAO();
            
            Utilizador user = new Utilizador(nome, senha, email);
            
            if(!Objects.equals(dao.getConexao(), null)){

                if(dao.create(user) == 1){
                    
                    System.out.println("utilizador registado com sucesso");
                }
                else
                {
                    System.err.println("Não foi possivel registar o utilizador");
                }
            }
            else
            {
                System.err.println("Erro: Não foi possivel estabelecer a conexao!!!");
            }
         }
         
        
         
         
         
         //HttpSession session;
         if(senha.equals("julio186")){
            
             
            response.sendRedirect( "home.jsp" );
            
         }
         else
         {
           
           mensagem = "Login invalido!";
           //session = request.getSession();
           request.setAttribute("mensagemErro", mensagem);
           response.sendRedirect( "index.jsp" );
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
