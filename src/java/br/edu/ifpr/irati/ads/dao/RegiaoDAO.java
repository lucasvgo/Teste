package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Estado;
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
public class RegiaoDAO implements IRegiaoDAO {

    @Override
    public void inserirRegiao(Regiao regiao) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "insert into REGIAO (CodRegiao, NomeRegiao) VALUES (?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, regiao.getCodRegiao());
            ps.setString(2, regiao.getNomeRegiao());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(RegiaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterarRegiao(Regiao regiao) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "UPDATE regiao set NomeRegiao = ? WHERE CodRegiao = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, regiao.getNomeRegiao());
            ps.setInt(2, regiao.getCodRegiao());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(RegiaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Regiao consultarRegiaoPorNome(String nome) {
        Regiao r = new Regiao();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodRegiao, NomeRegiao from Regiao where NomeRegiao = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            
            rs.first();
            int codRegiao = rs.getInt(1);
            String nomeRegiao = rs.getString(2);

            r.setCodRegiao(codRegiao);
            r.setNomeRegiao(nomeRegiao);

            IEstadoDAO estadoDAO = new EstadoDAO();
            List<Estado> estados = estadoDAO.consultarEstadosPorRegiao(r);

            r.setEstados(estados);
            rs.close();
            ps.close();
            con.close();
            return r;

        } catch (SQLException ex) {

            return r;
        }

    }

    @Override
    public Regiao consultarRegiaoPorCodigo(int codigo) {
        Regiao r = new Regiao();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodRegiao, NomeRegiao from Regiao where CodRegiao = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            rs.first();

            int codRegiao = rs.getInt(1);
            String nomeRegiao = rs.getString(2);

            r.setCodRegiao(codRegiao);
            r.setNomeRegiao(nomeRegiao);

            IEstadoDAO estadoDAO = new EstadoDAO();
            List<Estado> estados = estadoDAO.consultarEstadosPorRegiao(r);

            r.setEstados(estados);

            rs.close();
            ps.close();
            con.close();
            return r;

        } catch (SQLException ex) {

            return r;
        }

    }

    @Override
    public List<Regiao> consultarRegioes() {
        List<Regiao> regioes = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodRegiao, NomeRegiao from Regiao";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //Atenção aqui!!!!
            IEstadoDAO estadoDAO = new EstadoDAO();
            while (rs.next()) {
                int codRegiao = rs.getInt(1);
                String nomeRegiao = rs.getString(2);
                /* Buscar os estados a partir de EstadoDAO */
                Regiao r = new Regiao(codRegiao, nomeRegiao);
                r.setEstados(estadoDAO.consultarEstadosPorRegiao(r));
                regioes.add(r);
            }
            rs.close();
            ps.close();
            con.close();
            return regioes;
        } catch (SQLException ex) {
            return regioes;
        }
    }

}
