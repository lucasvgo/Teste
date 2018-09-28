package br.edu.ifpr.irati.ads.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public class Regiao {

    private int codRegiao;
    private String nomeRegiao;
    private List<Estado> estados;

    public Regiao() {
        codRegiao = 0;
        nomeRegiao = "";
        estados = new ArrayList<>();
    }

    public Regiao(int codRegiao, String nomeRegiao) {
        this.codRegiao = codRegiao;
        this.nomeRegiao = nomeRegiao;
        this.estados = new ArrayList<>();
    }

    public Regiao(int codRegiao, String nomeRegiao, List<Estado> estados) {
        this.codRegiao = codRegiao;
        this.nomeRegiao = nomeRegiao;
        this.estados = estados;
    }

    public void adicionarEstado(Estado estado) {
        estados.add(estado);
    }

    public void removerEstado(Estado estado) {
        estados.remove(estado);
    }

    public List<Double> calcularIDHRegiao(int ano) {

        double idhG = 0;
        double idhR = 0;
        double idhL = 0;
        double idhE = 0;
        for (Estado e : estados) {
            //calcular os idhs dos estados
            List<Double> idhsEstado = e.calcularIDHEstado(ano);
            idhG += idhsEstado.get(0);
            idhR += idhsEstado.get(1);
            idhL += idhsEstado.get(2);
            idhE += idhsEstado.get(3);
        }
        idhG = idhG / estados.size();
        idhR = idhR / estados.size();
        idhL = idhL / estados.size();
        idhE = idhE / estados.size();

        List<Double> idhs = new ArrayList<>();
        idhs.add(idhG);
        idhs.add(idhR);
        idhs.add(idhL);
        idhs.add(idhE);
        return idhs;
    }

    public int getCodRegiao() {
        return codRegiao;
    }

    public void setCodRegiao(int codRegiao) {
        this.codRegiao = codRegiao;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
