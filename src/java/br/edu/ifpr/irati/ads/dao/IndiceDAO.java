package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Indice;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import br.edu.ifpr.irati.ads.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valter Estevam
 */
public class IndiceDAO implements IIndiceDAO {

    @Override
    public void inserirIndice(Indice indice) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "insert into indice (CodMunicipio, Ano, IDH_Geral, IDH_Renda, IDH_Longevidade, IDH_Educacao) values ( ?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, indice.getMunicipio().getCodMunicipio());
            ps.setInt(2, indice.getAno());
            ps.setDouble(3, indice.getIdhGeral());
            ps.setDouble(4, indice.getIdhRenda());
            ps.setDouble(5, indice.getIdhLongevidade());
            ps.setDouble(6, indice.getIdhEducacao());

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(IndiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterarIndice(Indice indice) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "update indice set IDH_Geral = ?, IDH_Renda = ?, IDH_Longevidade = ?, IDH_Educacao = ? where CodMunicipio = ? AND ano = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDouble(1, indice.getIdhGeral());
            ps.setDouble(2, indice.getIdhRenda());
            ps.setDouble(3, indice.getIdhLongevidade());
            ps.setDouble(4, indice.getIdhEducacao());
            ps.setInt(5,indice.getMunicipio().getCodMunicipio());
            ps.setInt(6, indice.getAno());
            ps.executeUpdate();
            ps.close();
            con.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IndiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Indice consultarIndicePorCodigo(int codigo) {
        Indice i = new Indice();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, Ano, IDH_Geral, IDH_Renda, IDH_Longevidade, IDH_Educacao from indice where CodMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            rs.first();

            int codMunicipio = rs.getInt(1);
            int Ano = rs.getInt(2);
            double idhGeral = rs.getDouble(3);
            double idhRenda = rs.getDouble(4);
            double idhLogevidade = rs.getDouble(5);
            double idhEducacao = rs.getDouble(6);

            IMunicipioDAO municipioDAO = new MunicipioDAO();
            Municipio m = municipioDAO.consultarMunicipioPorCodigo(codMunicipio);

            i.setAno(Ano);
            i.setIdhGeral(idhGeral);
            i.setIdhRenda(idhRenda);
            i.setIdhLongevidade(idhLogevidade);
            i.setIdhEducacao(idhEducacao);
            i.setMunicipio(m);

            rs.close();
            ps.close();
            con.close();

            return i;

        } catch (SQLException ex) {
            return i;
        }
    }

    @Override
    public Indice consultarIndicePorMunicipioAno(Municipio municipio, int ano) {
        Indice i = new Indice();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, Ano, IDH_Geral, IDH_Renda, IDH_Longevidade, IDH_Educacao from indice where CodMunicipio = ? and Ano = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, municipio.getCodMunicipio());
            ps.setInt(2, ano);

            ResultSet rs = ps.executeQuery();

            rs.first();

            int codMunicipio = rs.getInt(1);
            int Ano = rs.getInt(2);
            double idhGeral = rs.getDouble(3);
            double idhRenda = rs.getDouble(4);
            double idhLogevidade = rs.getDouble(5);
            double idhEducacao = rs.getDouble(6);

            IMunicipioDAO municipioDAO = new MunicipioDAO();
            Municipio m = municipioDAO.consultarMunicipioPorCodigo(codMunicipio);

            i.setAno(Ano);
            i.setIdhGeral(idhGeral);
            i.setIdhRenda(idhRenda);
            i.setIdhLongevidade(idhLogevidade);
            i.setIdhEducacao(idhEducacao);
            i.setMunicipio(m);

            rs.close();
            ps.close();
            con.close();

            return i;

        } catch (SQLException ex) {
            return i;
        }
    }

    @Override
    public List<Indice> consultarIndicesPorAno(int ano) {
        List<Indice> indices = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, Ano, IDH_Geral, IDH_Renda, IDH_Longevidade, IDH_Educacao from indice where Ano = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ano);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codMunicipio = rs.getInt(1);
                int Ano = rs.getInt(2);
                double idhGeral = rs.getDouble(3);
                double idhRenda = rs.getDouble(4);
                double idhLogevidade = rs.getDouble(5);
                double idhEducacao = rs.getDouble(6);
//
                IMunicipioDAO municipioDAO = new MunicipioDAO();
//                Municipio m = municipioDAO.consultarNomeMunicipioPorCodigo(codMunicipio);
//                
                Indice i = new Indice();
                
                i.setAno(Ano);
                i.setIdhGeral(idhGeral);
                i.setIdhRenda(idhRenda);
                i.setIdhLongevidade(idhLogevidade);
                i.setIdhEducacao(idhEducacao);
//                i.setMunicipio(m);

                indices.add(i);
            }
            rs.close();
            ps.close();
            con.close();
            return indices;
        } catch (SQLException ex) {
            return indices;
        }
    }

    @Override
    public List<Indice> consultarIndicesPorMunicipio(Municipio municipio) {
        List<Indice> indices = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select Ano, IDH_Educacao, IDH_Longevidade, IDH_Renda, IDH_Geral from Indice where CodMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, municipio.getCodMunicipio());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ano = rs.getInt(1);
                double idhEducacao = rs.getDouble(2);
                double idhLongevidade = rs.getDouble(3);
                double idhRenda = rs.getDouble(4);
                double idhGeral = rs.getDouble(5);
                Indice i = new Indice(municipio, ano, idhGeral, idhRenda, idhLongevidade, idhEducacao);
                indices.add(i);
            }
            rs.close();
            ps.close();
            con.close();
            return indices;
        } catch (SQLException ex) {
            return indices;
        }

    }

    @Override
    public List<Municipio> consultarIndicesMunicipios(List<Municipio> municipios) {
        try {
            //1º buscar todos os índices
            //2º para cada municipio - encontrar os índices correspondentes e
            //vincular ao municipio

            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, Ano, IDH_Educacao, "
                    + "IDH_Geral, IDH_Longevidade, IDH_Renda from Indice";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Municipio municipio = new Municipio();
                for (Municipio m : municipios) {
                    if (m.getCodMunicipio() == id) {
                        municipio = m;
                        break;
                    }
                }
                int ano = rs.getInt(2);
                double idhEducacao = rs.getDouble(3);
                double idhGeral = rs.getDouble(4);
                double idhLongevidade = rs.getDouble(5);
                double idhRenda = rs.getDouble(6);
                Indice i = new Indice(municipio, ano, idhGeral, idhRenda, idhLongevidade, idhEducacao);
                municipio.adicionarIndice(i);
            }
            rs.close();
            ps.close();
            con.close();
            return municipios;
        } catch (SQLException ex) {
            return municipios;
        }
    }

}
