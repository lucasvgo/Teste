<%-- 
    Document   : formalteracaoregiaoGUI
    Created on : 29/09/2017, 15:17:49
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Regiao"%>
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
        <title>Formulario Regiões</title>
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
                    int IdRegiao = Integer.parseInt(request.getParameter("idRegiao"));
                    Controle c = new Controle();
                    Regiao r = c.consultarRegiaoPorCodigo(IdRegiao);

                %>    

                <form class="form-group" action="alterarregiao.jsp" method ="POST">
                    <div>
                        <label for="id" class="control-label">Codigo da Regiao: </label>
                        <input readonly="true" type="text" name="id" size="60" value="<%=r.getCodRegiao()%>" placeholder="Nome da Regiao" class="form-control" />
                    </div>  
                    <div>
                        <label for="nome" class="control-label">Região: </label>
                        <input type="text" name="nome" size="60" value="<%=r.getNomeRegiao()%>" placeholder="Nome da Regiao" class="form-control" />
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
