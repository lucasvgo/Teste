<%-- 
    Document   : formalteracaoindiceGUI
    Created on : 17/10/2017, 09:42:00
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Indice"%>
<%@page import="br.edu.ifpr.irati.ads.servlet.ServletAno"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpr.irati.ads.modelo.Municipio"%>
<%@page import="br.edu.ifpr.irati.ads.controle.Controle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/prefixfree.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Alteração de Indices</title>
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
                    int idMunicipio = Integer.parseInt(request.getParameter("idMunicipio"));
                    
                    Controle c = new Controle();
                    Municipio m = c.consultarMunicipioPorId(idMunicipio);
                    Indice i = c.consultarIndicePorMunicipioAno(m, ServletAno.ano);
                    
                    
                    

                %>  

                <form class="form-group" action="alterarindice.jsp" method ="POST">
                    <div>
                        <label for="idMunicipio" class="control-label">Codigo: </label>
                        <input readonly="true" type="text" name="idMunicipio" size="60" value="<%=i.getMunicipio().getCodMunicipio()%>" placeholder="Codigo do Municipio" class="form-control" />
                    </div>
                    <div>
                        <label for="nomeMunicipio" class="control-label">Municipio: </label>
                        <input readonly="true" type="text" name="nomeMunicipio" size="60" value="<%=i.getMunicipio().getNomeMunicipio()%>" placeholder="Municipio" class="form-control" />
                    </div>
                    
                    <div>
                        <label for="ano" class="control-label">Ano da Coleta: </label>
                        <input type="text" name="ano" size="60" value="<%=i.getAno()%>" placeholder="Ano da Coleta" class="form-control" />
                    </div>
                    <div>
                        <label for="idhGeral" class="control-label">IDH Geral: </label>
                        <input type="text" name="idhGeral" size="60" value="<%=i.getIdhGeral()%>" placeholder="IDH Geral" class="form-control" />
                    </div>
                    <div>
                        <label for="idhRenda" class="control-label">IDH Renda: </label>
                        <input type="text" name="idhRenda" size="60" value="<%=i.getIdhRenda()%>" placeholder="IDH Renda" class="form-control" />
                    </div> 
                    <div>
                        <label for="idhLongevidade" class="control-label">IDH Longevidade: </label>
                        <input type="text" name="idhLongevidade" size="60" value="<%=i.getIdhLongevidade()%>"placeholder="IDH Longevidade" class="form-control" />
                    </div> 
                    <div>
                        <label for="idhEducacao" class="control-label">IDH Educação: </label>
                        <input type="text" name="idhEducacao" size="60" value="<%=i.getIdhEducacao()%>" placeholder="IDH Educação" class="form-control" />
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
