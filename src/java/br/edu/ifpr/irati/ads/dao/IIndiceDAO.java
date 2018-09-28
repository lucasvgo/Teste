package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.modelo.Indice;
import br.edu.ifpr.irati.ads.modelo.Municipio;
import java.util.List;

/**
 *
 * @author Valter Estevam
 */
public interface IIndiceDAO {
    
    public void inserirIndice(Indice indice);
    
    public void alterarIndice(Indice indice);
    
    public Indice consultarIndicePorCodigo(int codigo);
    
    public Indice consultarIndicePorMunicipioAno(Municipio municipio, int ano);
    
    public List<Indice> consultarIndicesPorAno(int ano);
    
    public List<Indice> consultarIndicesPorMunicipio(Municipio municipio);
    
    public List<Municipio> consultarIndicesMunicipios(List<Municipio> municipios);
    
}
