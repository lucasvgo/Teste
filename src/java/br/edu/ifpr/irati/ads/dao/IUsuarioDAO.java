/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Usuario;

/**
 *
 * @author Carbono
 */
public interface IUsuarioDAO {
    public Usuario Login(String nome,String senha);
    
    
}
