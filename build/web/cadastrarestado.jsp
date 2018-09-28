<%-- 
    Document   : cadastrarestado
    Created on : 03/10/2017, 09:59:43
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Regiao"%>
<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Estado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nome = request.getParameter("nome");
            int id = Integer.parseInt(request.getParameter("id"));
            String sigla = request.getParameter("sigla");
            int idRegiao = Integer.parseInt(request.getParameter("regiao"));

            
            Controle controle = new Controle();
            Regiao r = new Regiao();
            r = controle.consultarRegiaoPorCodigo(idRegiao);
            Estado e = new Estado(id, nome, sigla, r);


            controle.inserirEstado(e);
            response.sendRedirect("estadosGUI.jsp");
            

        %> 
    </body>
</html>
