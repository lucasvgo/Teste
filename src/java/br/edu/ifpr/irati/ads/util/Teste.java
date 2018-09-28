/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.irati.ads.util;

import br.edu.ifpr.irati.ads.controle.Controle;
import br.edu.ifpr.irati.ads.dao.EstadoDAO;
import br.edu.ifpr.irati.ads.dao.IEstadoDAO;
import br.edu.ifpr.irati.ads.dao.IIndiceDAO;
import br.edu.ifpr.irati.ads.dao.IMunicipioDAO;
import br.edu.ifpr.irati.ads.dao.IRegiaoDAO;
import br.edu.ifpr.irati.ads.dao.IUsuarioDAO;
import br.edu.ifpr.irati.ads.dao.IndiceDAO;
import br.edu.ifpr.irati.ads.dao.MunicipioDAO;
import br.edu.ifpr.irati.ads.dao.RegiaoDAO;
import br.edu.ifpr.irati.ads.dao.UsuarioDAO;
import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Indice;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import br.edu.ifpr.irati.ads.modelo.Regiao;
import br.edu.ifpr.irati.ads.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Carbono
 */
public class Teste {

    public static void main(String[] args) {
        IIndiceDAO indiceDAO = new IndiceDAO();
        
        Controle c = new Controle();
//        Estado e = c.consultarEstadoPorNome("Rondonia");
//        Municipio m = c.consultarMunicipioPorId(110002);
//        Municipio m = new Municipio(110002, "Ariquemes2", e);
//        c.alterarMunicipio(m);
//          Regiao r = c.consultarRegiaoPorCodigo(5);
//          Estado e = new Estado(16, "Parana2", "PR", r);
//          c.alterarEstado(e);
        IMunicipioDAO municipioDAO = new MunicipioDAO();
//        
        List<Municipio> ms = c.consultarMunicipiosPorParteNome("Imbi");
        System.out.println(ms.get(0).getNomeMunicipio());
        System.out.println(ms.get(1).getNomeMunicipio());
        System.out.println(ms.get(2).getNomeMunicipio());
        
//          


//        

//        Indice i = new Indice(m, 1991, 0.799, 0.801, 0.731, 0.864);
//        indiceDAO.alterarIndice(i);

//        IUsuarioDAO usuarioDAO = new UsuarioDAO();
//        Usuario u = usuarioDAO.Login("ze", "134");
//        System.out.println(u.getUsuario()+u.getSenha());
//        IEstadoDAO estadoDAO = new EstadoDAO();
//        Estado e = estadoDAO.consultarEstadoPorCodigo(8);
//        System.out.println(e.getNomeEstado());
//            for (Municipio m : e.getMunicipios()){
//                System.out.println(m.getNomeMunicipio());
//            }
//           IMunicipioDAO municipioDAO = new MunicipioDAO();
//           Municipio m = municipioDAO.consultarMunicipioPorCodigo(110001);
//           System.out.println(m.getNomeMunicipio());
//            for (Indice i : m.getIndices()){
//                System.out.println(i.getIdhGeral());
//                
//            }
//            IMunicipioDAO municipioDAO = new MunicipioDAO();
//            Municipio m = municipioDAO.consultarNomeMunicipioPorCodigo(110001);
//            System.out.println(m.getNomeMunicipio());
//        
//        IIndiceDAO indiceDAO = new IndiceDAO();
//        List<Indice> indices = indiceDAO.consultarIndicesPorAno(1991);
//        for(Indice i : indices ){
//            System.out.println(i.getMunicipio().getNomeMunicipio());
//            System.out.println(i.getIdhGeral());
//            System.out.println(i.getIdhRenda());
//            System.out.println(i.getIdhLongevidade());
//            System.out.println(i.getIdhEducacao());
//        }
//        Regiao r1 = new Regiao();
//        r1.setCodRegiao(7);
//        r1.setNomeRegiao("MedioSul");
//        IRegiaoDAO regiaoDAO = new RegiaoDAO();
//        Regiao r = regiaoDAO.consultarRegiaoPorNome("Sul");
//        System.out.println(r.getNomeRegiao());
//        for (Estado e : r.getEstados()) {
//            System.out.println("\n" + e.getNomeEstado());
//        }
//        regiaoDAO.inserirRegiao(r1);
//            Estado e1 = new Estado();
//            e1.setCodEstado(28);
//            e1.setNomeEstado("ParanaUe");
//            e1.setSiglaEstado("PU");
//            e1.setRegiao(r1);
//        IEstadoDAO estadoDAO = new EstadoDAO();
//        estadoDAO.inserirEstado(e1);
//            Municipio m1 = new Municipio();
//            m1.setCodMunicipio(230838);
//            m1.setNomeMunicipio("Imbituvopolis");
//            m1.setEstado(e1);
//            IMunicipioDAO municipioDAO = new MunicipioDAO();
//        municipioDAO.inserirMunicipio(m1);
    }
}
