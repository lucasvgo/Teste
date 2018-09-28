package br.edu.ifpr.irati.ads.modelo;

/**
 *
 * @author Valter Estevam
 */
public class Indice {
    
    private Municipio municipio;
    private int ano;
    private double idhGeral;
    private double idhRenda;
    private double idhLongevidade;
    private double idhEducacao;

    public Indice() {
        municipio = new Municipio();
        ano = 0;
        idhGeral = 0;
        idhRenda = 0;
        idhLongevidade = 0;
        idhEducacao = 0;
    }
        
    public Indice(int ano, double idhGeral, double idhRenda, double idhLongevidade, double idhEducacao) {
        this.municipio = new Municipio();
        this.ano = ano;
        this.idhGeral = idhGeral;
        this.idhRenda = idhRenda;
        this.idhLongevidade = idhLongevidade;
        this.idhEducacao = idhEducacao;
    }

    public Indice(Municipio municipio, int ano, double idhGeral, double idhRenda, double idhLongevidade, double idhEducacao) {
        this.municipio = municipio;
        this.ano = ano;
        this.idhGeral = idhGeral;
        this.idhRenda = idhRenda;
        this.idhLongevidade = idhLongevidade;
        this.idhEducacao = idhEducacao;
    }
              
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getIdhGeral() {
        return idhGeral;
    }

    public void setIdhGeral(double idhGeral) {
        this.idhGeral = idhGeral;
    }

    public double getIdhRenda() {
        return idhRenda;
    }

    public void setIdhRenda(double idhRenda) {
        this.idhRenda = idhRenda;
    }

    public double getIdhLongevidade() {
        return idhLongevidade;
    }

    public void setIdhLongevidade(double idhLongevidade) {
        this.idhLongevidade = idhLongevidade;
    }

    public double getIdhEducacao() {
        return idhEducacao;
    }

    public void setIdhEducacao(double idhEducacao) {
        this.idhEducacao = idhEducacao;
    }
    
}
