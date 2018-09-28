<%-- 
    Document   : alterarestado
    Created on : 03/10/2017, 11:06:54
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Estado"%>
<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Regiao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String sigla = request.getParameter("sigla");
            String regiao = request.getParameter("regiao");

            
            Controle controle = new Controle();
            Regiao r = new Regiao();
            r = controle.consultarRegiaoPorNome(regiao);
            Estado e = new Estado(id, nome, sigla, r);


            controle.alterarEstado(e);
            response.sendRedirect("estadosGUI.jsp?idRegiao=0");

        %>  
    </body>
</html>
