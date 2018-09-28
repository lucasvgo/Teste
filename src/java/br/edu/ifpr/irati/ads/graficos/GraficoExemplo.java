package br.edu.ifpr.irati.ads.graficos;

import java.util.Date;
import java.util.Map;

import org.jfree.data.category.DefaultCategoryDataset;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;

public class GraficoExemplo implements DatasetProducer {

    public Object produceDataset(Map arg0) throws DatasetProduceException {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();

        ds.addValue(new Double(25000), "País", "PR");
        ds.addValue(new Double(5000), "Exterior", "PR");
        ds.addValue(new Double(22000), "País", "SP");
        ds.addValue(new Double(10000), "Exterior", "SP");
        ds.addValue(new Double(21000), "País", "SC");
        ds.addValue(new Double(15000), "Exterior", "SC");
        ds.addValue(new Double(15000), "País", "RJ");
        ds.addValue(new Double(1000), "Exterior", "RJ");
        ds.addValue(new Double(10000), "País", "RS");
        ds.addValue(new Double(1500), "Exterior", "RS");

        return ds;
    }

    public boolean hasExpired(Map arg0, Date arg1) {
        return true;
    }

    public String getProducerId() {
        return "Grafico1";
    }
}