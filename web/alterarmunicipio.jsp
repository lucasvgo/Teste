<%-- 
    Document   : alterarmunicipio
    Created on : 03/10/2017, 16:46:39
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Municipio"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Regiao"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Estado"%>
<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
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
            String nomeEstado = request.getParameter("estado");

            Controle controle = new Controle();
            
            Estado e = controle.consultarEstadoPorNome(nomeEstado);
            Municipio m = new Municipio(id, nome, e);
            controle.alterarMunicipio(m);
            response.sendRedirect("municipiosGUI.jsp?idEstado=0");

        %>  
    </body>
</html>
