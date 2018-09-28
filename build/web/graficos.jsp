<%-- 
    Document   : graficos
    Created on : 13/10/2017, 16:51:31
    Author     : Carbono
--%>

<%@page import="br.edu.ifpr.irati.ads.modelo.Municipio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html"%>
<%@taglib uri='/WEB-INF/cewolf.tld' prefix='cewolf' %>
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
        <title>Graficos</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <ul class="nav nav-pills">
                    <li class=""><a href="index.jsp">Inicio</a></li>
                    <li class=""><a href="selecionaAno.jsp">Selecionar Ano</a></li>
                    <li class=""><a href="logout.jsp">Fazer Logout</a></li>
                </ul>
                <h2>Graficos comparativos dos IDHs</h2>
                <center>
                    <jsp:useBean id="bean1" class="br.edu.ifpr.irati.ads.graficos.GraficoIdhGeral"/>
                    <cewolf:chart id="grafico2"
                                  title="IDH Geral"
                                  type="line"
                                  xaxislabel=""
                                  yaxislabel="">
                        <cewolf:gradientpaint>
                            <cewolf:point x="350" y="0" color="#FBFBFB" />
                            <cewolf:point x="350" y="0" color="#F3F3F3" />
                        </cewolf:gradientpaint>
                        <cewolf:chartpostprocessor id="bean1"/>
                        <cewolf:data>
                            <cewolf:producer id="bean1"/>
                        </cewolf:data>
                    </cewolf:chart>
                    <p>
                        <cewolf:img chartid="grafico2" renderer="/cewolf" width="600" height="350"/>
                    <p>


                        <jsp:useBean id="bean2" class="br.edu.ifpr.irati.ads.graficos.GraficoIdhRenda"/>
                        <cewolf:chart id="grafico3"
                                      title="IDH Renda"
                                      type="line"
                                      xaxislabel=""
                                      yaxislabel="">
                            <cewolf:gradientpaint>
                                <cewolf:point x="350" y="0" color="#FBFBFB" />
                                <cewolf:point x="350" y="0" color="#F3F3F3" />
                            </cewolf:gradientpaint>
                            <cewolf:chartpostprocessor id="bean2"/>
                            <cewolf:data>
                                <cewolf:producer id="bean2"/>
                            </cewolf:data>
                        </cewolf:chart>
                    <p>
                        <cewolf:img chartid="grafico3" renderer="/cewolf" width="600" height="350"/>
                    <p>
                        <jsp:useBean id="bean3" class="br.edu.ifpr.irati.ads.graficos.GraficoIdhLongevidade"/>
                        <cewolf:chart id="grafico4"
                                      title="IDH Longevidade"
                                      type="line"
                                      xaxislabel=""
                                      yaxislabel="">
                            <cewolf:gradientpaint>
                                <cewolf:point x="350" y="0" color="#FBFBFB" />
                                <cewolf:point x="350" y="0" color="#F3F3F3" />
                            </cewolf:gradientpaint>
                            <cewolf:chartpostprocessor id="bean3"/>
                            <cewolf:data>
                                <cewolf:producer id="bean3"/>
                            </cewolf:data>
                        </cewolf:chart>
                    <p>
                        <cewolf:img chartid="grafico4" renderer="/cewolf" width="600" height="350"/>
                    <p>
                        <jsp:useBean id="bean4" class="br.edu.ifpr.irati.ads.graficos.GraficoIdhEducacao"/>
                        <cewolf:chart id="grafico5"
                                      title="IDH Educação"
                                      type="line"
                                      xaxislabel=""
                                      yaxislabel="">
                            <cewolf:gradientpaint>
                                <cewolf:point x="350" y="0" color="#FBFBFB" />
                                <cewolf:point x="350" y="0" color="#F3F3F3" />
                            </cewolf:gradientpaint>
                            <cewolf:chartpostprocessor id="bean4"/>
                            <cewolf:data>
                                <cewolf:producer id="bean4"/>
                            </cewolf:data>
                        </cewolf:chart>
                    <p>
                        <cewolf:img chartid="grafico5" renderer="/cewolf" width="600" height="350"/>
                    <p>
                </center>
            </div>
        </div>    

    </body>
</html>
