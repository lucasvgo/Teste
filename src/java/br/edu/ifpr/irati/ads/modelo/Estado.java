package br.edu.ifpr.irati.ads.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public class Estado {
    
    private int codEstado;
    private String nomeEstado;
    private String siglaEstado;
    private List<Municipio> municipios;
    private Regiao regiao;

    public Estado() {
        codEstado = 0;
        nomeEstado = "";
        siglaEstado = "";
        municipios = new ArrayList<>();
        regiao = new Regiao();
    }

    public Estado(int codEstado, String nomeEstado, String siglaEstado) {
        this.codEstado = codEstado;
        this.nomeEstado = nomeEstado;
        this.siglaEstado = siglaEstado;
        this.municipios = new ArrayList<>();
        this.regiao = new Regiao();
    }
    
    public Estado(int codEstado, String nomeEstado, String siglaEstado, Regiao regiao) {
        this.codEstado = codEstado;
        this.nomeEstado = nomeEstado;
        this.siglaEstado = siglaEstado;
        this.municipios = new ArrayList<>();
        this.regiao = regiao;
    }
    
    public Estado(int codEstado, String nomeEstado, String siglaEstado, List<Municipio> municipios, Regiao regiao) {
        this.codEstado = codEstado;
        this.nomeEstado = nomeEstado;
        this.siglaEstado = siglaEstado;
        this.municipios = municipios;
        this.regiao = regiao;
    }
        
    public void adicionarMunicipio(Municipio municipio){
        municipios.add(municipio);
    }
    
    public void removerMunicipio(Municipio municipio){
        municipios.remove(municipio);
    }
    
    public List<Double> calcularIDHEstado(int ano) {
        double idhG = 0;
        double idhR = 0;
        double idhL = 0;
        double idhE = 0;
        for (Municipio m: municipios){
            //calcular os idhs dos estados
            List<Double> idhsMunicipio = m.calcularIDHMunicipio(ano);
            idhG += idhsMunicipio.get(0);
            idhR += idhsMunicipio.get(1);
            idhL += idhsMunicipio.get(2);
            idhE += idhsMunicipio.get(3);
        }        
        idhG = idhG / municipios.size();
        idhR = idhR / municipios.size();
        idhL = idhL / municipios.size();
        idhE = idhE / municipios.size();
        
        List<Double> idhs = new ArrayList<>();
        idhs.add(idhG);
        idhs.add(idhR);
        idhs.add(idhL);
        idhs.add(idhE);
        return idhs;
    }
    
    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
    
}
