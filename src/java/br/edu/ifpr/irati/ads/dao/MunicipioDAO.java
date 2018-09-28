package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Indice;
import br.edu.ifpr.irati.ads.modelo.Municipio;
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
public class MunicipioDAO implements IMunicipioDAO {

    @Override
    public void inserirMunicipio(Municipio municipio) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "insert into municipio (CodMunicipio, NomeMunicipio, CodEstado) values (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, municipio.getCodMunicipio());
            ps.setString(2, municipio.getNomeMunicipio());
            ps.setInt(3, municipio.getEstado().getCodEstado());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterarMunicipio(Municipio municipio) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "update municipio set NomeMunicipio = ?, CodEstado = ? where CodMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, municipio.getNomeMunicipio());
            ps.setInt(2, municipio.getEstado().getCodEstado());
            ps.setInt(3, municipio.getCodMunicipio());

            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Municipio consultarMunicipioPorNome(String nome) {
        Municipio m = new Municipio();
        try {

            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, NomeMunicipio, CodEstado from municipio where NomeMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.first();

            int codMunicipio = rs.getInt(1);
            String nomeMunicipio = rs.getString(2);
            int codEstado = rs.getInt(3);

            m.setCodMunicipio(codMunicipio);
            m.setNomeMunicipio(nomeMunicipio);

            IEstadoDAO estadoDAO = new EstadoDAO();
            Estado e = estadoDAO.consultarEstadoPorCodigo(codEstado);

            m.setEstado(e);

            IIndiceDAO indiceDAO = new IndiceDAO();
            List<Indice> indices = indiceDAO.consultarIndicesPorMunicipio(m);

            m.setIndices(indices);

            rs.close();
            ps.close();
            con.close();
            return m;

        } catch (SQLException ex) {
            return m;
        }

    }

    @Override
    public Municipio consultarMunicipioPorCodigo(int codigo) {
        Municipio m = new Municipio();
        try {

            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, NomeMunicipio, CodEstado from municipio where CodMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            rs.first();

            int codMunicipio = rs.getInt(1);
            String nomeMunicipio = rs.getString(2);
            int codEstado = rs.getInt(3);

            m.setCodMunicipio(codMunicipio);
            m.setNomeMunicipio(nomeMunicipio);

            IEstadoDAO estadoDAO = new EstadoDAO();
            Estado e = estadoDAO.consultarEstadoPorCodigo(codEstado);

            m.setEstado(e);

            IIndiceDAO indiceDAO = new IndiceDAO();
            List<Indice> indices = indiceDAO.consultarIndicesPorMunicipio(m);

            m.setIndices(indices);

            rs.close();
            ps.close();
            con.close();
            return m;

        } catch (SQLException ex) {
            return m;
        }
    }

    @Override
    public List<Municipio> consultarMunicipiosPorEstado(Estado estado) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, NomeMunicipio from Municipio where CodEstado = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estado.getCodEstado());
            ResultSet rs = ps.executeQuery();
            IIndiceDAO indiceDAO = new IndiceDAO();
            while (rs.next()) {
                int codMunicipio = rs.getInt(1);
                String nomeMunicipio = rs.getString(2);
                /*buscar os índices por municipio*/
                Municipio m = new Municipio(codMunicipio, nomeMunicipio, estado);
                //m.setIndices(indiceDAO.consultarIndicesPorMunicipio(m));
                municipios.add(m);
            }

            //buscar índices dos municípios
            municipios = indiceDAO.consultarIndicesMunicipios(municipios);

            rs.close();
            ps.close();
            con.close();
            return municipios;
        } catch (SQLException ex) {
            return municipios;
        }
    }

    @Override
    public List<Municipio> consultarMunicipios() {
        List<Municipio> municipios = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, NomeMunicipio from Municipio";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            IIndiceDAO indiceDAO = new IndiceDAO();
            while (rs.next()) {
                int codMunicipio = rs.getInt(1);
                String nomeMunicipio = rs.getString(2);
                /*buscar os índices por municipio*/
                Municipio m = new Municipio(codMunicipio, nomeMunicipio);
                //m.setIndices(indiceDAO.consultarIndicesPorMunicipio(m));
                municipios.add(m);
            }

            //buscar índices dos municípios
            municipios = indiceDAO.consultarIndicesMunicipios(municipios);

            rs.close();
            ps.close();
            con.close();
            return municipios;
        } catch (SQLException ex) {
            return municipios;
        }
    }

    @Override
    public Municipio consultarNomeMunicipioPorCodigo(int codigo) {
        Municipio m = new Municipio();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select NomeMunicipio from Municipio where CodMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            rs.first();

            String nomeMunicipio = rs.getString(1);

            m.setNomeMunicipio(nomeMunicipio);

            rs.close();
            ps.close();
            con.close();

            return m;

        } catch (SQLException ex) {
            return m;
        }
    }

    @Override
    public void excluirMunicipio(Municipio municipio) {
        try {
            Connection con = new Conexao().conectar();
            String sql = "DELETE FROM indice where codMunicipio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, municipio.getCodMunicipio());
            ps.execute();

            String sql2 = "DELETE FROM municipio where codMunicipio = ?";
            ps = con.prepareStatement(sql2);
            ps.setInt(1, municipio.getCodMunicipio());
            ps.execute();

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Municipio> consultarMunicipioParteNome(String pNome) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select CodMunicipio, NomeMunicipio, CodEstado from municipio where NomeMunicipio like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + pNome + "%");
            ResultSet rs = ps.executeQuery();
            IIndiceDAO indiceDAO = new IndiceDAO();
            while (rs.next()) {
                int codMunicipio = rs.getInt(1);
                String nomeMunicipio = rs.getString(2);
                int codEstado = rs.getInt(3);
                Municipio m = new Municipio(codMunicipio, nomeMunicipio);
                municipios.add(m);
            }
            municipios = indiceDAO.consultarIndicesMunicipios(municipios);

            rs.close();
            ps.close();
            con.close();
            return municipios;

        } catch (SQLException ex) {
            return municipios;
        }
    }
}
