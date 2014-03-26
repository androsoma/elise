/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.FabricanteFacade;
import ejb.inventario.TipoTransformadorFacade;
import entidades.inventario.Fabricante;
import entidades.inventario.TipoTransformador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author LENOVO
 */
@Named("inventario")
@SessionScoped
public class InventarioControl implements Serializable {

    @EJB
    @Inject
    TipoTransformadorFacade tipoTransformadorFacade;
    @EJB
    @Inject
    FabricanteFacade fabricanteFacade;
    List<TipoTransformador> tiposTransformador = null;
    List<Fabricante> fabricantes = null;
    TipoTransformador tipoTransformadorSeleccionado = new TipoTransformador();
    Fabricante fabricanteSeleccionado = new Fabricante();
    boolean tipo = false;

    /**
     * Creates a new instance of InventarioControl
     */
    public InventarioControl() {
    }

    public TipoTransformadorFacade getTipoTransformadorFacade() {
        return tipoTransformadorFacade;
    }

    public void setTipoTransformadorFacade(TipoTransformadorFacade tipoTransformadorFacade) {
        this.tipoTransformadorFacade = tipoTransformadorFacade;
    }

    public FabricanteFacade getFabricanteFacade() {
        return fabricanteFacade;
    }

    public void setFabricanteFacade(FabricanteFacade fabricanteFacade) {
        this.fabricanteFacade = fabricanteFacade;
    }

    public List<TipoTransformador> getTiposTransformador() {
        return tiposTransformador;
    }

    public void setTiposTransformador(List<TipoTransformador> tiposTransformador) {
        this.tiposTransformador = tiposTransformador;
    }

    public TipoTransformador getTipoTransformadorSeleccionado() {
        return tipoTransformadorSeleccionado;
    }

    public void setTipoTransformadorSeleccionado(TipoTransformador tipoTransformadorSeleccionado) {
        this.tipoTransformadorSeleccionado = tipoTransformadorSeleccionado;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public Fabricante getFabricanteSeleccionado() {
        return fabricanteSeleccionado;
    }

    public void setFabricanteSeleccionado(Fabricante fabricanteSeleccionado) {
        this.fabricanteSeleccionado = fabricanteSeleccionado;
    }
    
    public String inicializarPunto() {
        tiposTransformador = new ArrayList<>();
        fabricantes = new ArrayList<>();

        tiposTransformador = getTipoTransformadorFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();

        tipo = true;

        return "pm:transformador";
    }
}
