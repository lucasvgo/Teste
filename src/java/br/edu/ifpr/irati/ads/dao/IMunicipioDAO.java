package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Estado;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public interface IMunicipioDAO {
    
    public void inserirMunicipio(Municipio municipio);
    
    public void alterarMunicipio(Municipio municipio);
   
    public void excluirMunicipio(Municipio municipio);
    
    public Municipio consultarMunicipioPorNome(String nome);
    
    public Municipio consultarMunicipioPorCodigo(int codigo);
    
    public List<Municipio> consultarMunicipiosPorEstado(Estado estado);
    
    public List<Municipio> consultarMunicipios();
    
    public Municipio consultarNomeMunicipioPorCodigo(int codigo);
    
    public List<Municipio> consultarMunicipioParteNome(String pNome);
    
    
}
