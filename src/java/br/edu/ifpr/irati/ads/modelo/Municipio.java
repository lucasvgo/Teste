package br.edu.ifpr.irati.ads.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public class Municipio {
    
    private int codMunicipio;
    private String nomeMunicipio;
    private Estado estado;
    private List<Indice> indices;

    public Municipio() {
        codMunicipio = 0;
        nomeMunicipio = "";
        estado = new Estado();
        indices = new ArrayList<>();
    }
    
    public Municipio(int codMunicipio, String nomeMunicipio) {
        this.codMunicipio = codMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.estado = new Estado();
        this.indices = new ArrayList<>();
    }
    
    public Municipio(int codMunicipio, String nomeMunicipio, Estado estado) {
        this.codMunicipio = codMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.estado = estado;
        this.indices = new ArrayList<>();
    }

    public Municipio(int codMunicipio, String nomeMunicipio, Estado estado, List<Indice> indices) {
        this.codMunicipio = codMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.estado = estado;
        this.indices = indices;
    }
            
    public void adicionarIndice(Indice indice){
        indices.add(indice);
    }
    
    public void removerIndice(Indice indice){
        indices.remove(indice);
    }
    
    public List<Double> calcularIDHMunicipio(int ano) {
        
        List<Double> idhs = new ArrayList<>();
        for (Indice i : indices){
            if (i.getAno() == ano){
                idhs.add(i.getIdhGeral());
                idhs.add(i.getIdhRenda());
                idhs.add(i.getIdhLongevidade());
                idhs.add(i.getIdhEducacao());
                break;
            }
        }
        return idhs;        
    }
    
    public int getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Indice> getIndices() {
        return indices;
    }

    public void setIndices(List<Indice> indices) {
        this.indices = indices;
    }
    
}
