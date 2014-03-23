/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.inventario;

import ejb.inventario.TipoTransformadorFacade;
import entidades.inventario.TipoTransformador;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lbertel
 */
@Named("tipoTrans")
@RequestScoped
public class TipoTransformadorControl {

    TipoTransformador tt = new TipoTransformador();
    
    @Inject
    TipoTransformadorFacade ttf;
    
    private String cadenaBuscada;

    public String getCadenaBuscada() {
        return cadenaBuscada;
    }

    public void setCadenaBuscada(String cadenaBuscada) {
        this.cadenaBuscada = cadenaBuscada;
    }
    
    public TipoTransformadorControl() {
        
        
    }

    public TipoTransformador getTt() {
        return tt;
    }

    public void setTt(TipoTransformador tt) {
        this.tt = tt;
    }

    public TipoTransformadorFacade getTtf() {
        return ttf;
    }

    public void setTtf(TipoTransformadorFacade ttf) {
        this.ttf = ttf;
    }
    
    public void buscarPorTipoTransformador(){
         tt = getTtf().buscarPorNombre(cadenaBuscada);
         
         System.out.println("Tipo transformador = " + tt.getDescripcion());
    }
    
}
