<%-- 
    Document   : cadastrarindice
    Created on : 17/10/2017, 09:23:44
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Municipio"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Indice"%>
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
            int idMunicipio = Integer.parseInt(request.getParameter("idMunicipio"));
            int ano = Integer.parseInt(request.getParameter("ano"));
            double idhGeral = Double.parseDouble(request.getParameter("idhGeral"));
            double idhRenda = Double.parseDouble(request.getParameter("idhRenda"));
            double idhLongevidade = Double.parseDouble(request.getParameter("idhLongevidade"));
            double idhEducacao = Double.parseDouble(request.getParameter("idhEducacao"));
            
            Controle controle = new Controle();
            Municipio m = new Municipio();
            m = controle.consultarMunicipioPorId(idMunicipio);
            
            Indice i = new Indice(m, ano, idhGeral, idhRenda, idhLongevidade, idhEducacao);
            controle.inserirIndice(i);
            response.sendRedirect("municipiosGUI.jsp?idEstado=0");
            
            
            
            %>
    </body>
</html>
