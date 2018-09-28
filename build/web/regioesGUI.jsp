<%-- 
    Document   : regioesGUI
    Created on : 29/09/2017, 11:27:20
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.servlet.ServletAno"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Regiao"%>
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
        <title>Lista de Regiões</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <ul class="nav nav-pills">
                    <li class=""><a href="index.jsp">Inicio</a></li>
                    <li class=""><a href="selecionaAno.jsp">Selecionar Ano</a></li>
                    <li class=""><a href="logout.jsp">Fazer Logout</a></li>
                </ul>
                <h2>IDH das Regioes Brasileiras no ano de <%=(ServletAno.ano)%> </h2>
                <div class="btn">
                    <a href="formregioesGUI.jsp"><input type="button" value="Adicionar" name="adicionar" class="btn btn-primary"></a> 
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
                                <td> Ver Estados </td>
                                <td> Alterar </td>
                            </tr>
                        </thread>
                        <%
                            /*int ano = Integer.parseInt(request.getParameter("ano"));*/
                            Controle c = new Controle();
                            
                            for (Regiao r : c.consultarRegioes()) {


                        %>
                        <tr>
                            <td><%=r.getNomeRegiao()%></td>
                            <td><%=r.calcularIDHRegiao(ServletAno.ano).get(0)%></td>
                            <td><%=r.calcularIDHRegiao(ServletAno.ano).get(1)%></td>
                            <td><%=r.calcularIDHRegiao(ServletAno.ano).get(2)%></td>
                            <td><%=r.calcularIDHRegiao(ServletAno.ano).get(3)%></td>
                            <td> <a href="estadosGUI.jsp?idRegiao=<%=r.getCodRegiao()%>"><input type="button" value="Estados" class="btn btn-primary"></a></td>
                            <td> <a href="formalteracaoregiaoGUI.jsp?idRegiao=<%=r.getCodRegiao()%>"><input type="button" value="Alterar" class="btn btn-primary"></a></td>
                        </tr>
                        <%}
                        %>

                </div>
            </div>    

    </body>
</html>