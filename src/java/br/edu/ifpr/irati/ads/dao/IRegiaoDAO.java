package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Regiao;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public interface IRegiaoDAO {
    
    public void inserirRegiao(Regiao regiao);
    
    public void alterarRegiao(Regiao regiao);
            
    public Regiao consultarRegiaoPorNome(String nome);
    
    public Regiao consultarRegiaoPorCodigo(int codigo);
 
    public List<Regiao> consultarRegioes();    
}
