/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.inventario;

import entidades.inventario.Configuracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yeison Osorio
 */
@Stateless
public class ConfiguracionFacade extends AbstractFacade<Configuracion> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;
    
    private Configuracion configuracion;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionFacade() {
        super(Configuracion.class);
    }
    
    public String obtenerValorConfiguracionPorNombre(String nombre){
        configuracion = new Configuracion();
        
        Query query = em.createNamedQuery("Configuracion.findByNombre");
        query.setParameter("nombre", nombre);
        
        configuracion = (Configuracion) query.getSingleResult();
        
        if (configuracion == null) {
            return null;
        }
        
        return configuracion.getValor();
    }
    
}
