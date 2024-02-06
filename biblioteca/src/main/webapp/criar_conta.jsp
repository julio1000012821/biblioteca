<%-- 
    Document   : index_2
    Created on : 05/02/2024, 17:34:34
    Author     : juliosilva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <div style="margin-top:100px;">
                <form  action="LoginServlet" method="POST">
                    <div style="margin-bottom: 30px;"><!-- comment -->
                      Criar conta
                    </div>
                    <div>
                        <label>Nome  </label>
                        <input type="text" name="username" placeholder="insere o nome" />
                    </div>
                    <div>
                        <label>Email  </label>
                        <input type="email" name="email" placeholder="insere o nome" />
                    </div>
                    <div style="margin-bottom: 30px;">
                        <label>senha   </label>
                        <input type="password" name="senha" placeholder="insere a password" />
                    </div>
                    <input type="hidden" name="operacao" value="criar_conta" />
                    <button type="submit" >Entrar</button>
                </form>
            </div>
       </center>
    </body>
</html>
