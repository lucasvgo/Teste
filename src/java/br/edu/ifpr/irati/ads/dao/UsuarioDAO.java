/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Usuario;
import br.edu.ifpr.irati.ads.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carbono
 */
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public Usuario Login(String nome, String senha) {
        Usuario usuario = new Usuario();
        try {
            Connection con = new Conexao().conectar();
            String sql = "select usuario,senha from Usuario where usuario = ? and senha = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nomeUsuario = rs.getString(1);
                String senhaUsuario = rs.getString(2);
                Usuario u = new Usuario(nomeUsuario, senhaUsuario);
                usuario = u;
            }
            rs.close();
            ps.close();
            con.close();
            return usuario;
        } catch (SQLException ex) {
            return null;
        }
    }
}


//    @Override
//    public boolean login(Usuario usuario) {
//        Usuario u = new Usuario();
//        try {
//            Connection con = new Conexao().conectar();
//            String sql = "select usuario, senha from usuario where usuario = ? AND senha = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, usuario.getUsuario());
//            ps.setString(2, usuario.getSenha());
//            
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                
//                String usua = rs.getString(1);
//                String pass = rs.getString(2);
//                u.setSenha(usua);
//                u.setUsuario(pass);
//            }
//            
//            rs.close();
//            ps.close();
//            con.close();
//            return true;
//        } catch (SQLException ex) {
//            return false;
//        }
//    }
//}
