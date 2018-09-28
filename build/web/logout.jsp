<%-- 
    Document   : logout
    Created on : 26/08/2017, 09:52:31
    Author     : valter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
            session = request.getSession();
            session.setAttribute("logado",false);
            session.setAttribute("nomeusuario","");
            response.sendRedirect("index.jsp");            
        %>
    </body>
</html>
