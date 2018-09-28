<%-- 
    Document   : formestadosGUI
    Created on : 03/10/2017, 09:55:49
    Author     : Carbono
--%>

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

                <form class="form-group" action="cadastrarestado.jsp" method ="POST">

                    <div>
                        <label for="id" class="control-label">Codigo: </label>
                        <input type="text" name="id" size="60" placeholder="Codigo do Estado (28)" class="form-control" />
                    </div> 
                    <div>
                        <label for="nome" class="control-label">Estado: </label>
                        <input type="text" name="nome" size="60" placeholder="Nome do Estado" class="form-control" />
                    </div>
                    <div>
                        <label for="sigla" class="control-label">Sigla: </label>
                        <input type="text" name="sigla" size="60" placeholder="Sigla do Estado" class="form-control" />
                    </div>
                    <div>
                        <label for="estado" class="control-label">Id da Regiao: </label>
                        <input type="text" name="regiao" size="60" placeholder="Id da Regiao (ex: 2)" class="form-control" />
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