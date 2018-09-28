<%-- 
    Document   : municipiosGUI
    Created on : 02/10/2017, 15:23:45
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.servlet.ServletAno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Municipio"%>
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
                <h2>IDH dos Municipios Brasileiros no ano de <%=(ServletAno.ano)%> </h2>
                <div class="btn">
                    <a href="formmunicipiosGUI.jsp"><input type="button" value="Adicionar" name="adicionar" class="btn btn-primary"></a> 
                </div>
                
                <div>
                    <table class="table table-striped" border="2" width ="50%">
                        <thread>
                            <tr class ="success">
                                <td> Nome </td>
                                <td> IDH Geral </td>
                                <td> IDH Renda </td>
                                <td> IDH Longevidade </td>
                                <td> IDH Educação </td>
                                <td> Alterar </td>
                                <td> Corrigir Indices </td>
                                <td> Ver Graficos </td>
                            </tr>
                        </thread>
                        <%

                            int IdEstado = Integer.parseInt(request.getParameter("idEstado"));
                            Controle c = new Controle();
                            List<Municipio> municipios = new ArrayList<>();
                            if (IdEstado != 0) {
                                Estado e = c.consultarEstadoPorId(IdEstado);
                                municipios = c.consultarMunicipiosPorEstado(e);
                            } else {
                                municipios = c.consultarMunicipios();
                            }
                            for (Municipio m : municipios) {
                        %>
                        <tr>
                            <td><%=m.getNomeMunicipio()%></td>
                            <td><%=m.calcularIDHMunicipio(ServletAno.ano).get(0)%></td>
                            <td><%=m.calcularIDHMunicipio(ServletAno.ano).get(1)%></td>
                            <td><%=m.calcularIDHMunicipio(ServletAno.ano).get(2)%></td>
                            <td><%=m.calcularIDHMunicipio(ServletAno.ano).get(3)%></td>
                            <td> <a href="formalteracaomunicipios.jsp?idMunicipio=<%=m.getCodMunicipio()%>"><input type="button" value="Alterar" class="btn btn-primary"></a></td>
                            <td> <a href="formalteracaoindiceGUI.jsp?idMunicipio=<%=m.getCodMunicipio()%>"><input type="button" value="Corrigir Indices" class="btn btn-primary"></a></td>
                            <td> <a href="servlet?idMunicipio=<%=m.getCodMunicipio()%>"><input type="button" value="Ver Graficos" class="btn btn-primary"></a></td>
                        </tr>
                        <%}
                        %>



                </div>
            </div>    
    </body>
</html>
