<%-- 
    Document   : home
    Created on : 05/02/2024, 17:42:31
    Author     : juliosilva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="utilizadordao" class="com.standard.biblioteca.dao.UtilizadorDAO" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listagem de utilizadores </h1>
            <table style="border: 1px solid black;">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>email</th>
                    </tr>
                </thead>
                <tbody >
                    <c:forEach var="item"  items="${utilizadordao.findAll()}">
                       <tr>
                            <td>${item.idUtilizador}</td>
                            <td>${item.nome}</td>
                            <td>${item.email}</td>
                            <td><button >Editar<button/></td>
                            <td><button>Remover</button></td>
                       </tr> 
                    </c:forEach>
                </tbody>
            </table>       
    </body>
</html>
