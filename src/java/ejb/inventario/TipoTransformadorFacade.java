/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.inventario;

import entidades.inventario.TipoTransformador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lbertel
 */
@Stateless
public class TipoTransformadorFacade extends AbstractFacade<TipoTransformador> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTransformadorFacade() {
        super(TipoTransformador.class);
    }
    
    /**
     * <p>busca un tipo de transformador por su nombre</p>
     * @param nombre El nombre del tipo de transformador
     * @return Un TipoTransformador que corresponda al nombre buscado
     */
    public TipoTransformador buscarPorNombre(String nombre){
        Query query = em.createNamedQuery(TipoTransformador.BUSCAR_POR_NOMBRE); query.setParameter("nombre", nombre); 
        
        return  (TipoTransformador) query.getSingleResult();
        
    }
    
}