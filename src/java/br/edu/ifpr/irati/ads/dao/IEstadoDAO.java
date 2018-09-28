package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Regiao;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public interface IEstadoDAO {
    
    public void inserirEstado(Estado estado);
    
    public void alterarEstado(Estado estado);
    
    public Estado consultarEstadoPorCodigo(int codigo);
    
    public Estado consultarEstadoPorNome(String nome);
    
    public List<Estado> consultarEstadosPorRegiao(Regiao regiao);
    
    public List<Estado> consultarEstados();
}
