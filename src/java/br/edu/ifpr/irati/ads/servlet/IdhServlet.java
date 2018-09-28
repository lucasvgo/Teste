/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.controle.Controle;
import br.edu.ifpr.irati.ads.modelo.Regiao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carbono
 */
public class IdhServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        Controle c = new Controle();
        List<Integer> anos = new ArrayList<>();
        anos.add(1991);
        anos.add(2000);
        anos.add(2010);
        
        
        PrintWriter pw = response.getWriter();
        
        pw.println("<html>");
        pw.println("<head>");
//        pw.println("<meta charset=\"utf-8\"/");
        pw.println("<link rel=\"stylesheet\" type=\"text/css\"href=\"css/estilo.css\"/>");
        pw.println("</head>");
        pw.println("<body>");
        
        List<String> labels = new ArrayList<>();
        List<List<Double>> idhsTabela = new ArrayList<>();
        
        for(int ano: anos){
            labels.add("Brasil"+ano);
            List<Double> idhs = c.calcularIDHTotalPais(ano);
            idhsTabela.add(idhs);
        }
        
        String tabela = criarTabela(labels, idhsTabela);
        pw.write(tabela);
        
        List<Regiao> regioes = c.getRegioes();
        List<String> labelsRegioes = new ArrayList<>();
        List<List<Double>> idhsTabelaRegioes = new ArrayList<>();
        int ano = 1991;
        for(Regiao r: regioes){
            labelsRegioes.add(r.getNomeRegiao());
            idhsTabelaRegioes.add(r.calcularIDHRegiao(ano));
        }
        pw.println("<br/>");
        pw.println(criarTabela(labelsRegioes, idhsTabelaRegioes));
        
        
        
        
        pw.println("</body>");
        pw.println("</html>");
        
 
        
        
        
        
    }
    public String criarTabela(List<String> labelLinha, List<List<Double>> idhsTabela){
        
        StringBuilder sb = new StringBuilder();
        sb.append("<table border = \"1\">");
        sb.append("<tr>");
        sb.append("<th> </th>");
        sb.append("<th>IDH Geral</th>");
        sb.append("<th>IDH Renda</th>");
        sb.append("<th>IDH Longevidade</th>");
        sb.append("<th>IDH Educação</th>");
        sb.append("</tr>");
        int i =0;
        for (List<Double> idhs: idhsTabela){
            String label = labelLinha.get(i);
            double idhGeral = idhs.get(0);
            double idhRenda = idhs.get(1);
            double idhLongevidade = idhs.get(2);
            double idhEducacao = idhs.get(3);
            sb.append("<tr>");
            sb.append("<td>"+label+"</td>");
            sb.append("<td>"+idhGeral+"</td>");
            sb.append("<td>"+idhRenda+"</td>");
            sb.append("<td>"+idhLongevidade+"</td>");
            sb.append("<td>"+idhEducacao+"</td>");
            sb.append("</tr>");
            
            i++;
            
                    
        }
        sb.append("</table>");
        return sb.toString();
        
    }
}
