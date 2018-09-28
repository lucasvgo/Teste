<%-- 
    Document   : logar
    Created on : 03/10/2017, 20:06:30
    Author     : Carbono
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <fieldset style="width: 100px; margin: 100px auto;">
            <legend>Autenticação</legend>
            <form action="login.jsp" method="post">
                <p> Usuário: <input type="text" size="20" name="nomeusuario"/> </p>
                <p> Senha: <input type="password" size="20" name="senhausuario"/> </p>
                <p> <input type="submit" value="Entrar"/> </p>
            </form>
        </fieldset>
    </body>
</html>
