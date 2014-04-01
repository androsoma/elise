/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.mantenimiento;

import entidades.mantenimiento.ReportePuntoLuz;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LENOVO
 */
@Stateless
public class ReportePuntoLuzFacade extends AbstractFacade<ReportePuntoLuz> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportePuntoLuzFacade() {
        super(ReportePuntoLuz.class);
    }
    
}
