package br.edu.ifpr.irati.ads.graficos;

import br.edu.ifpr.irati.ads.controle.Controle;
import br.edu.ifpr.irati.ads.dao.EstadoDAO;
import br.edu.ifpr.irati.ads.dao.IEstadoDAO;
import br.edu.ifpr.irati.ads.dao.IIndiceDAO;
import br.edu.ifpr.irati.ads.dao.IMunicipioDAO;
import br.edu.ifpr.irati.ads.dao.IRegiaoDAO;
import br.edu.ifpr.irati.ads.dao.IndiceDAO;
import br.edu.ifpr.irati.ads.dao.MunicipioDAO;
import br.edu.ifpr.irati.ads.dao.RegiaoDAO;
import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Indice;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import br.edu.ifpr.irati.ads.modelo.Regiao;
import de.laures.cewolf.ChartPostProcessor;
import java.util.Date;
import java.util.Map;

import org.jfree.data.category.DefaultCategoryDataset;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.Range;

public class GraficoIdhLongevidade implements DatasetProducer, ChartPostProcessor {

    public Object produceDataset(Map arg0) throws DatasetProduceException {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        Controle controle = new Controle();
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        IEstadoDAO estadoDAO = new EstadoDAO();
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        IIndiceDAO indiceDAO = new IndiceDAO();

        int idMunicipio = br.edu.ifpr.irati.ads.servlet.Servlet.idMunicipio;

        Municipio municipio = municipioDAO.consultarMunicipioPorCodigo(idMunicipio);
        Estado estado = municipio.getEstado();
        estado.setMunicipios(municipioDAO.consultarMunicipiosPorEstado(estado));
        Regiao regiao = estado.getRegiao();
        regiao.setEstados(estadoDAO.consultarEstadosPorRegiao(regiao));
        List<Indice> indices = indiceDAO.consultarIndicesPorMunicipio(municipio);


////        Pegar valores do municipio
//        
//        Municipio municipio = controle.consultarMunicipioPorId(idMunicipio);
//        double idhGeral = municipio.calcularIDHMunicipio(1991).get(0);
//        double idhRenda = municipio.calcularIDHMunicipio(1991).get(1);
//        double idhLongevidade = municipio.calcularIDHMunicipio(1991).get(2);
//        double idhEducacao = municipio.calcularIDHMunicipio(1991).get(3);
//        
//        Estado estado = controle.consultarEstadoPorId(municipio.getEstado().getCodEstado());
//        double idhGeralEstado = estado.calcularIDHEstado(1991).get(0);
//        double idhRendaEstado = estado.calcularIDHEstado(1991).get(1);
//        double idhLongevidadeEstado = estado.calcularIDHEstado(1991).get(2);
//        double idhEducacaoEstado = estado.calcularIDHEstado(1991).get(3);
//        
//        ds.addValue(idhGeral, PRODUCER_ATTRIBUTE_NAME, PRODUCER_ATTRIBUTE_NAME);
        for (Indice indice : indices) {
            ds.addValue(indice.getIdhLongevidade(), municipio.getNomeMunicipio(), String.valueOf(indice.getAno()));
            List<Double> indiceEstado = estado.calcularIDHEstado(indice.getAno());
            ds.addValue(indiceEstado.get(2), estado.getNomeEstado(), String.valueOf(indice.getAno()));
            List<Double>indiceRegiao = regiao.calcularIDHRegiao(indice.getAno());
            ds.addValue(indiceRegiao.get(2), regiao.getNomeRegiao(), String.valueOf(indice.getAno()));
            List<Double>indicePais = controle.calcularIDHTotalPais(indice.getAno());
            ds.addValue(indicePais.get(2),"Brasil", String.valueOf(indice.getAno()));
        }
        return ds;

//        ds.addValue(0.65, "País", "1991");
//        ds.addValue(0.71, "País", "2000");
//        ds.addValue(0.75, "País", "2010");
//        
//        
//        ds.addValue(0.62, "Sul", "1991");
//        ds.addValue(0.70, "Sul", "2000");
//        ds.addValue(0.73, "Sul", "2010");
//       
//        
//        ds.addValue(0.67, "Paraná", "1991");
//        ds.addValue(0.73, "Paraná", "2000");
//        ds.addValue(0.76, "Paraná", "2010");
//        
//                
//        ds.addValue(0.62, "Irati", "1991");
//        ds.addValue(0.70, "Irati", "2000");
//        ds.addValue(0.71, "Irati", "2010");
//        
//       
//        return ds;
    }

    public boolean hasExpired(Map arg0, Date arg1) {
        return true;
    }

    public String getProducerId() {
        return "Grafico4";
    }

    @Override
    public void processChart(JFreeChart jfc, Map<String, String> map) {
        JFreeChart chart = (JFreeChart) jfc;
        CategoryPlot categoryPlot = chart.getCategoryPlot();

        NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
        rangeAxis.setAutoRange(false);
        Range range = new Range(0.5, 1);
        rangeAxis.setRange(range);
        //Altero as cores das series de meus itens 
        //CategoryPlot categoryPlot = chart.getCategoryPlot(); 
        CategoryItemRenderer renderer = categoryPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.BLACK);
    }
}
