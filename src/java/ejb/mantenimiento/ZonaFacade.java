/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.mantenimiento;

import entidades.mantenimiento.Zona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lbertel
 */
@Stateless
public class ZonaFacade extends AbstractFacade<Zona> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonaFacade() {
        super(Zona.class);
    }
    
}
