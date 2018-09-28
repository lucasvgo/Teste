<%-- 
    Document   : selecionaAno
    Created on : 13/10/2017, 18:29:02
    Author     : Carbono
--%>

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
        
    </head>
    <body>
        <div>
            <form class = "form-control" name="ano" action="formano.jsp" method="get">
                <select class="btn btn-primary dropdown-toggle" name="ano" >
                    <option value="">Selecione um Ano</option>
                    <option value="1991">1991</option>
                    <option value="2000">2000</option>
                    <option value="2010">2010</option>
                </select>
                <input type="submit" value="Salvar" name="salvar" class="btn btn-success"/>
            </form>    
        </div>
    </body>
</html>
