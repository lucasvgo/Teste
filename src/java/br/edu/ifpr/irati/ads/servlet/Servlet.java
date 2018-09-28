/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.irati.ads.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carbono
 */
public class Servlet extends HttpServlet {

    public static int idMunicipio = 0;

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        idMunicipio = Integer.parseInt(req.getParameter("idMunicipio"));
        resp.sendRedirect("graficos.jsp?&idMunicipio=" + idMunicipio);
    }
}
