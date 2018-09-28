<%-- 
    Document   : formano
    Created on : 05/10/2017, 15:07:37
    Author     : Carbono
--%>

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
            
            String ano = request.getParameter("ano");

            response.sendRedirect("servletAno?ano="+ano);

        %>  
    </body>
</html>
