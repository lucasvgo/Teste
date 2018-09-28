<%-- 
    Document   : estadosGUI
    Created on : 29/09/2017, 10:45:30
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.servlet.ServletAno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Regiao"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Estado"%>
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
        <title>Lista de Estados</title>
    </head>
    <body>

        <div class="container">
            <div class="jumbotron">
                <ul class="nav nav-pills">
                    <li class=""><a href="index.jsp">Inicio</a></li>
                    <li class=""><a href="selecionaAno.jsp">Selecionar Ano</a></li>
                    <li class=""><a href="logout.jsp">Fazer Logout</a></li>
                </ul>
                <h2>IDH dos Estados Brasileiros no ano de <%=(ServletAno.ano)%> </h2>
                <div class="btn">
                    <a href="formregioesGUI.jsp"><input type="button" value="Adicionar" name="adicionar" class="btn btn-primary"></a> 
                </div>


                <div>
                    <table class="table table-striped" border="2" width ="50%">
                        <thread>
                            <tr class ="success">
                                <td> Nome </td>
                                <td> Sigla </td>
                                <td> IDH Geral </td>
                                <td> IDH Renda </td>
                                <td> IDH Longevidade </td>
                                <td> IDH Educação </td>
                                <td> Ver Municipios </td>
                                <td> Alterar </td>
                            </tr>
                        </thread>
                        <%
                            int IdRegiao = Integer.parseInt(request.getParameter("idRegiao"));
                            Controle c = new Controle();
                            List<Estado> estados = new ArrayList<>();
                            if (IdRegiao != 0) {
                                Regiao r = c.consultarRegiaoPorCodigo(IdRegiao);
                                estados = c.consultarEstadosPorRegiao(r);
                            } else {
                                estados = c.consultarEstados();
                            }
                            for (Estado e : estados) {
                        %>
                        <tr>
                            <td><%=e.getNomeEstado()%></td>
                            <td><%=e.getSiglaEstado()%></td>
                            <td><%=e.calcularIDHEstado(ServletAno.ano).get(0)%></td>
                            <td><%=e.calcularIDHEstado(ServletAno.ano).get(1)%></td>
                            <td><%=e.calcularIDHEstado(ServletAno.ano).get(2)%></td>
                            <td><%=e.calcularIDHEstado(ServletAno.ano).get(3)%></td>
                            <td> <a href="municipiosGUI.jsp?idEstado=<%=e.getCodEstado()%>"><input type="button" value="Municipios" class="btn btn-primary"></a></td>
                            <td> <a href="formalteracaoestadosGUI.jsp?IdEstado=<%=e.getCodEstado()%>"><input type="button" value="Alterar" class="btn btn-primary"></a></td>
                        </tr>
                        <%}
                        %>

                </div>
            </div>    

    </body>
</html>