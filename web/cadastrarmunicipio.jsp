<%-- 
    Document   : cadastrarmunicipio
    Created on : 03/10/2017, 15:58:47
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Municipio"%>
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
            String nome = request.getParameter("nome");
            int id = Integer.parseInt(request.getParameter("id"));
            int idEstado = Integer.parseInt(request.getParameter("estado"));

            Controle controle = new Controle();
            Estado e = new Estado();
            e = controle.consultarEstadoPorId(idEstado);
            Municipio m = new Municipio(id, nome, e);
            controle.inserirMunicipio(m);
            response.sendRedirect("municipiosGUI.jsp?idEstado=0");


        %> 
    </body>
</html>
