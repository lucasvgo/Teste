<%-- 
    Document   : formalteracaoestadosGUI
    Created on : 03/10/2017, 10:55:10
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Estado"%>
<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/prefixfree.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Formulario Estados</title>
    </head>
    <body>
        <%
            String usuario = "";
            session = request.getSession();

            Object o = session.getAttribute("logado");
            if (o == null || ((Boolean) o) == false) {
                response.sendRedirect("acessonegado.jsp");
            } else {
                usuario = (String) session.getAttribute("nomeusuario");
            }
        %>
        <div class="container">
            <div class="jumbotron">
                <ul class="nav nav-pills">
                    <li class=""><a href="index.jsp">Inicio</a></li>
                    <li class=""><a href="logout.jsp">Fazer Logout</a></li>
                </ul>
                <%
                    int IdEstado = Integer.parseInt(request.getParameter("IdEstado"));

                    Controle c = new Controle();
                    Estado e = c.consultarEstadoPorId(IdEstado);


                %>  

                <form class="form-group" action="alterarestado.jsp" method ="POST">
                    <div>
                        <label for="id" class="control-label">Codigo do Estado: </label>
                        <input readonly="true" type="text" name="id" size="60" placeholder="" class="form-control" value="<%=e.getCodEstado()%>" />
                    </div>
                    <div>
                        <label for="nome" class="control-label">Estado: </label>
                        <input type="text" name="nome" size="60" placeholder="Nome do Estado" class="form-control" value="<%=e.getNomeEstado()%>" />
                    </div>
                    <div>
                        <label for="sigla" class="control-label">Sigla: </label>
                        <input type="text" name="sigla" size="60" placeholder="Sigla do Estado" class="form-control" value="<%=e.getSiglaEstado()%>" />
                    </div>
                    <div>
                        <label for="regiao" class="control-label">Regiao: </label>
                        <input type="text" name="regiao" size="60" placeholder="Regiao:" class="form-control" value="<%=e.getRegiao().getNomeRegiao()%>" />
                    </div>  


                    <div>
                        <br>
                        <input type="submit" value="Salvar" name="salvar" class="btn btn-success"/>
                    </div>
                </form>
            </div>
        </div>    

    </body>
</html>
