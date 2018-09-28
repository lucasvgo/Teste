package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import br.edu.ifpr.irati.ads.modelo.Regiao;
import br.edu.ifpr.irati.ads.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valter Estevam
 */
public class EstadoDAO implements IEstadoDAO {

    @Override
    public void inserirEstado(Estado estado) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "insert into ESTADO (CodEstado, NomeEstado, SiglaEstado, CodRegiao) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, estado.getCodEstado());
            ps.setString(2, estado.getNomeEstado());
            ps.setString(3, estado.getSiglaEstado());
            ps.setInt(4, estado.getRegiao().getCodRegiao());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterarEstado(Estado estado) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "update estado set NomeEstado = ?, SiglaEstado = ?, CodRegiao = ? where CodEstado = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, estado.getNomeEstado());
            ps.setString(2, estado.getSiglaEstado());
            ps.setInt(3, estado.getRegiao().getCodRegiao());
            ps.setInt(4, estado.getCodEstado());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Estado consultarEstadoPorCodigo(int codigo) {
        Estado e = new Estado();
        try {
            Connection con = new Conexao().conectar();
            String sql = "Select CodEstado, NomeEstado, SiglaEstado, CodRegiao from estado where CodEstado = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            rs.first();
            
            int codEstado = rs.getInt(1);
            String nomeEstado = rs.getString(2);
            String siglaEstado = rs.getString(3);
            int codRegiao = rs.getInt(4);
            
            e.setCodEstado(codEstado);
            e.setNomeEstado(nomeEstado);
            e.setSiglaEstado(siglaEstado);
            
            IRegiaoDAO regiaoDAO = new RegiaoDAO();
            Regiao r = regiaoDAO.consultarRegiaoPorCodigo(codRegiao);
            e.setRegiao(r);
            
            IMunicipioDAO municipioDAO = new MunicipioDAO();
            List<Municipio> municipios = municipioDAO.consultarMunicipiosPorEstado(e);
            
            e.setMunicipios(municipios);
            
            rs.close();
            ps.close();
            con.close();
            return e;

        } catch (SQLException ex) {
            return e;
        }
    }

    @Override
    public Estado consultarEstadoPorNome(String nome) {
         Estado e = new Estado();
        try {
            Connection con = new Conexao().conectar();
            String sql = "Select CodEstado, NomeEstado, SiglaEstado, CodRegiao from estado where NomeEstado = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.first();
            
            int codEstado = rs.getInt(1);
            String nomeEstado = rs.getString(2);
            String siglaEstado = rs.getString(3);
            int codRegiao = rs.getInt(4);
            
            
            e.setCodEstado(codEstado);
            e.setNomeEstado(nomeEstado);
            e.setSiglaEstado(siglaEstado);
            
            IRegiaoDAO regiaoDAO = new RegiaoDAO();
            Regiao r = regiaoDAO.consultarRegiaoPorCodigo(codRegiao);
            e.setRegiao(r);
            
            IMunicipioDAO municipioDAO = new MunicipioDAO();
            List<Municipio> municipios = municipioDAO.consultarMunicipiosPorEstado(e);
            
            e.setMunicipios(municipios);
            
            rs.close();
            ps.close();
            con.close();
            return e;

        } catch (SQLException ex) {
            return e;
        }
    }

    @Override
    public List<Estado> consultarEstadosPorRegiao(Regiao regiao) {
        List<Estado> estados = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodEstado, NomeEstado, SiglaEstado from Estado where CodRegiao = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, regiao.getCodRegiao());
            ResultSet rs = ps.executeQuery();
            IMunicipioDAO municipioDAO = new MunicipioDAO();
            while (rs.next()) {
                int codEstado = rs.getInt(1);
                String nomeEstado = rs.getString(2);
                String siglaEstado = rs.getString(3);
                /* buscar as cidades */
                Estado e = new Estado(codEstado, nomeEstado, siglaEstado, regiao);
                e.setMunicipios(municipioDAO.consultarMunicipiosPorEstado(e));
                estados.add(e);
            }
            rs.close();
            ps.close();
            con.close();
            return estados;
        } catch (SQLException ex) {
            return estados;
        }

    }

    @Override
    public List<Estado> consultarEstados() {
        List<Estado> estados = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodEstado, NomeEstado, SiglaEstado from Estado";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            IMunicipioDAO municipioDAO = new MunicipioDAO();
            while (rs.next()) {
                int codEstado = rs.getInt(1);
                String nomeEstado = rs.getString(2);
                String siglaEstado = rs.getString(3);
                /* buscar as cidades */
                Estado e = new Estado(codEstado, nomeEstado, siglaEstado);
                e.setMunicipios(municipioDAO.consultarMunicipiosPorEstado(e));
                estados.add(e);
            }
            rs.close();
            ps.close();
            con.close();
            return estados;
        } catch (SQLException ex) {
            return estados;
        }
    }

}
