package br.edu.ifpr.irati.ads.controle;

import br.edu.ifpr.irati.ads.dao.EstadoDAO;
import br.edu.ifpr.irati.ads.dao.IEstadoDAO;
import br.edu.ifpr.irati.ads.dao.IIndiceDAO;
import br.edu.ifpr.irati.ads.dao.IMunicipioDAO;
import br.edu.ifpr.irati.ads.dao.IRegiaoDAO;
import br.edu.ifpr.irati.ads.dao.MunicipioDAO;
import br.edu.ifpr.irati.ads.dao.RegiaoDAO;
import br.edu.ifpr.irati.ads.dao.UsuarioDAO;
import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Indice;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import br.edu.ifpr.irati.ads.modelo.Regiao;
import br.edu.ifpr.irati.ads.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpr.irati.ads.dao.IUsuarioDAO;
import br.edu.ifpr.irati.ads.dao.IndiceDAO;
import br.edu.ifpr.irati.ads.util.Digest;
import br.edu.ifpr.irati.ads.util.HashGenerationException;

/**
 *
 * @author Valter Estevam
 */
public class Controle {

    public List<Regiao> getRegioes() {
        return regioes;
    }

    private List<Regiao> regioes;

    public Boolean ControleLogin(String nome, String SenhaPlana) {
        String senha = "";
        try {
            senha = Digest.hashString(SenhaPlana, "SHA-256");
        } catch (HashGenerationException ex) {
            System.out.println(ex.getMessage());
            
        }

        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = usuarioDAO.Login(nome, senha);
        if ((u.getUsuario()) != "") {
            return true;
        } else {
            return false;
        }
    }

//    Regiao
//    --------------------------------------------------------------------------
    public List<Regiao> consultarRegioes() {
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        return regiaoDAO.consultarRegioes();
    }

    public void inserirRegiao(Regiao r) {
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.inserirRegiao(r);
    }

    public void alterarRegiao(Regiao r) {
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.alterarRegiao(r);
    }

    public Regiao consultarRegiaoPorCodigo(int id) {
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        return regiaoDAO.consultarRegiaoPorCodigo(id);
    }

    public Regiao consultarRegiaoPorNome(String nome) {
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        return regiaoDAO.consultarRegiaoPorNome(nome);
    }

    public List<Double> calcularIdhRegiao(Regiao r, int ano) {
        List<Double> IdhRegioes = r.calcularIDHRegiao(ano);
        return IdhRegioes;
    }

//   Estados 
//    --------------------------------------------------------------------------
    public List<Estado> consultarEstados() {
        IEstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultarEstados();
    }

    public List<Double> calcularIdhEstados(Estado e, int ano) {
        List<Double> IdhEstados = e.calcularIDHEstado(ano);
        return IdhEstados;
    }

    public List<Estado> consultarEstadosPorRegiao(Regiao r) {
        IEstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultarEstadosPorRegiao(r);
    }

    public void inserirEstado(Estado e) {
        IEstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.inserirEstado(e);
    }

    public void alterarEstado(Estado e) {
        IEstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.alterarEstado(e);
    }

    public Estado consultarEstadoPorId(int id) {
        IEstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultarEstadoPorCodigo(id);
    }

    public Estado consultarEstadoPorNome(String nome) {
        IEstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.consultarEstadoPorNome(nome);
    }

//    Municipios
//    --------------------------------------------------------------------------
    public List<Municipio> consultarMunicipios() {
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        return municipioDAO.consultarMunicipios();
    }

    public List<Municipio> consultarMunicipiosPorEstado(Estado e) {
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        return municipioDAO.consultarMunicipiosPorEstado(e);
    }

    public Municipio consultarMunicipioPorId(int id) {
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        return municipioDAO.consultarMunicipioPorCodigo(id);
    }

    public List<Double> consultarIdhMunicipios(Municipio m, int ano) {
        List<Double> IdhMunicipios = m.calcularIDHMunicipio(ano);
        return IdhMunicipios;
    }

    public void inserirMunicipio(Municipio m) {
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        municipioDAO.inserirMunicipio(m);
    }

    public void alterarMunicipio(Municipio m) {
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        municipioDAO.alterarMunicipio(m);
    }

    public void excluirMunicipio(Municipio m) {
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        municipioDAO.excluirMunicipio(m);
    }
    
    public List<Municipio> consultarMunicipiosPorParteNome(String pNome){
        IMunicipioDAO municipioDAO = new MunicipioDAO();
        return municipioDAO.consultarMunicipioParteNome(pNome);
    }
//    Indices
//    --------------------------------------------------------------------------

    public void inserirIndice(Indice i) {
        IIndiceDAO indiceDAO = new IndiceDAO();
        indiceDAO.inserirIndice(i);
    }

    public void alterarIndice(Indice i) {
        IIndiceDAO indiceDAO = new IndiceDAO();
        indiceDAO.alterarIndice(i);
    }

    public Indice consultarIndicePorCodigo(int id) {
        IIndiceDAO indiceDAO = new IndiceDAO();
        return indiceDAO.consultarIndicePorCodigo(id);
    }

    public Indice consultarIndicePorMunicipioAno(Municipio m, int ano) {
        IIndiceDAO indiceDAO = new IndiceDAO();
        return indiceDAO.consultarIndicePorMunicipioAno(m, ano);

    }

//    Login
//    --------------------------------------------------------------------------
//    public Boolean fazerLogin(Usuario u){
//        IUsuarioDAO usuarioDAO = new UsuarioDAO();
//        u = usuarioDAO.login(u);
//        
//    }
//    --------------------------------------------------------------------------
    public Controle() {
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        regioes = regiaoDAO.consultarRegioes();
    }

    /**
     *
     *
     * @param ano ano da pesquisa
     * @return Lista de 4 médias de índices nesta ordem: geral, renda,
     * longevidade e educação
     */
    public List<Double> calcularIDHTotalPais(int ano) {

        //1º calcular os idhs das regiões e fazer a
        //média aritmética simples destes valores
        double idhG = 0;
        double idhR = 0;
        double idhL = 0;
        double idhE = 0;
        for (Regiao r : getRegioes()) {
            //calcular os idhs da região
            List<Double> idhsRegiao = r.calcularIDHRegiao(ano);
            idhG += idhsRegiao.get(0);
            idhR += idhsRegiao.get(1);
            idhL += idhsRegiao.get(2);
            idhE += idhsRegiao.get(3);
        }
        idhG = idhG / getRegioes().size();
        idhR = idhR / getRegioes().size();
        idhL = idhL / getRegioes().size();
        idhE = idhE / getRegioes().size();

        List<Double> idhs = new ArrayList<>();
        idhs.add(idhG);
        idhs.add(idhR);
        idhs.add(idhL);
        idhs.add(idhE);
        return idhs;
    }

    public static void main(String[] args) {
        /*
        IRegiaoDAO regiaoDAO = new RegiaoDAO();
        List<Regiao> regioes = regiaoDAO.consultarRegioes();
        for (Regiao r : regioes) {
            System.out.println(r.getNomeRegiao());
            System.out.println("\n\nRelação de estados\n");
            for (Estado e : r.getEstados()) {
                System.out.println("\n" + e.getNomeEstado() + "\n\n");
                for (Municipio m : e.getMunicipios()) {
                    System.out.print(m.getNomeMunicipio() + "\t");
                    for (Indice i : m.getIndices()) {
                        System.out.print(i.getAno() + "  " + i.getIdhGeral() + "\t");
                    }
                    System.out.println("");
                }

            }
        }
         */

        Controle c = new Controle();
        List<Double> idhs = c.calcularIDHTotalPais(1991);
        System.out.println("Geral " + idhs.get(0));
        System.out.println("Renda " + idhs.get(1));
        System.out.println("Longevidade " + idhs.get(2));
        System.out.println("Educação " + idhs.get(3));

    }

}
