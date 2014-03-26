/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.inventario;

import ejb.inventario.TipoTransformadorFacade;
import entidades.inventario.TipoTransformador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lbertel
 */
@Named("tipoTransformador")
@SessionScoped
public class TipoTransformadorControl implements Serializable {    
    @EJB
    @Inject
    TipoTransformadorFacade ttf;
    List<TipoTransformador> tiposTransformador = null;
    TipoTransformador tipoTransformadorSeleccionado = new TipoTransformador();
    boolean tipo = false;
    
    private String cadenaBuscada;

    public String getCadenaBuscada() {
        return cadenaBuscada;
    }

    public void setCadenaBuscada(String cadenaBuscada) {
        this.cadenaBuscada = cadenaBuscada;
    }
    
    public TipoTransformadorControl() {
    }

    public TipoTransformador getTipoTransformadorSeleccionado() {
        return tipoTransformadorSeleccionado;
    }

    public void setTipoTransformadorSeleccionado(TipoTransformador tipoTransformadorSeleccionado) {
        this.tipoTransformadorSeleccionado = tipoTransformadorSeleccionado;
    }

    public List<TipoTransformador> getTiposTransformador() {
        return tiposTransformador;
    }

    public void setTiposTransformador(List<TipoTransformador> tiposTransformador) {
        this.tiposTransformador = tiposTransformador;
    }

    public TipoTransformadorFacade getTtf() {
        return ttf;
    }

    public void setTtf(TipoTransformadorFacade ttf) {
        this.ttf = ttf;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
    
    public String buscarTodos(){
        tiposTransformador = new ArrayList<TipoTransformador>();
        tiposTransformador = getTtf().findAll();
        System.out.println("ingrso al metodo buscar");
        tipo = true;
        return "pm:transformador";
    }
    
    public void cuantosTipos() {
        System.out.println("Tipos = " + tiposTransformador.size());
        tipo = true;
    }
    
    public void buscarPorId() {
        tipoTransformadorSeleccionado = getTtf().find(tipoTransformadorSeleccionado.getId());
    }
}
