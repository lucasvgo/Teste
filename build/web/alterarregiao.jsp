<%-- 
    Document   : alterarregiao
    Created on : 29/09/2017, 15:59:40
    Author     : Carbono
--%>

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
            String nome = request.getParameter("nome");
            int id = Integer.parseInt(request.getParameter("id"));
            
            Regiao r = new Regiao(id, nome);
            Controle controle = new Controle();
            
            controle.alterarRegiao(r);
            response.sendRedirect("regioesGUI.jsp");
            
        %>   
    </body>
</html>
