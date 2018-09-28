<%-- 
    Document   : login
    Created on : 26/08/2017, 09:37:46
    Author     : valter
--%>

<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%

            /* As sessões são criadas automaticamente pelo servlet container 
            basta solicitar a sessão atual */
            session = request.getSession(true);

            /* código de validação do login */
            String nome = request.getParameter("nomeusuario");
            String senhaPlana = request.getParameter("senhausuario");
            boolean login = false;
            /* em uma implementação real deveria ser chamado o controlador
            para fazer a valiação */
            Controle c = new Controle();
            login = c.ControleLogin(nome, senhaPlana);
            
            if (login==true) {
                session.setAttribute("logado", true);
                session.setAttribute("nomeusuario", nome);

                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("logado", false);
                response.sendRedirect("acessonegado.jsp");
            }
            /*if (nome.equals("ze") && senha.equals("123")){
                session.setAttribute("logado",true);
                session.setAttribute("nomeusuario",nome);
                
                response.sendRedirect("index.jsp");                
            }else{
                session.setAttribute("logado",false);
                response.sendRedirect("acessonegado.jsp");
            }*/

        %>
    </body>
</html>
