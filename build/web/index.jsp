<%-- 
    Document   : index
    Created on : 29/09/2017, 10:40:28
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.servlet.ServletAno"%>
<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/prefixfree.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <ul class="nav nav-pills">
                    <li class=""><a href="index.jsp">Inicio</a></li>
                    <li class=""><a href="selecionaAno.jsp">Selecionar Ano</a></li>
                    <li class=""><a href="regioesGUI.jsp?">Regiões</a></li>
                    <li class=""><a href="estadosGUI.jsp?idRegiao=0">Estados</a></li>
                    <li class=""><a href="municipiosGUI.jsp?idEstado=0">Municipios</a></li>
                    <li class=""><a href="formindiceGUI.jsp">Cadastrar Novo Indice</a></li>
                    <li class=""><a href="logar.jsp">Fazer Login</a></li>
                    <li class=""><a href="logout.jsp">Fazer Logout</a></li>
                </ul>

                <div>
                    <h2>IDH do Pais no ano de <%=(ServletAno.ano)%> </h2>
                    <table class="table table-striped" border="2" width ="50%">
                        <thread>
                            <tr class ="success">
                                <td> Pais </td>
                                <td> IDH Geral </td>
                                <td> IDH Renda </td>
                                <td> IDH Longevidade </td>
                                <td> IDH Educação </td>

                            </tr>
                        </thread>
                        <%
                            Controle c = new Controle();
                        %>
                        <tr>
                            <td>Brasil</td>
                            <td><%=c.calcularIDHTotalPais(ServletAno.ano).get(0)%></td>
                            <td><%=c.calcularIDHTotalPais(ServletAno.ano).get(1)%></td>
                            <td><%=c.calcularIDHTotalPais(ServletAno.ano).get(2)%></td>
                            <td><%=c.calcularIDHTotalPais(ServletAno.ano).get(3)%></td>
                        </tr>


                </div>


            </div>
        </div>    

    </body>
</html>
