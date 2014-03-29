/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.FabricanteFacade;
import ejb.inventario.TipoConexionTransformadorFacade;
import ejb.inventario.TipoTransformadorFacade;
import ejb.inventario.TransformadorFacade;
import entidades.inventario.Fabricante;
import entidades.inventario.PuntoLuz;
import entidades.inventario.TipoConexionTransformador;
import entidades.inventario.TipoTransformador;
import entidades.inventario.Transformador;
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

    @EJB
    @Inject
    TipoConexionTransformadorFacade tipoConexionTransformadorFacade;

    @EJB
    @Inject
    TransformadorFacade transformadorFacade;
    List<TipoTransformador> tiposTransformador = null;
    List<Fabricante> fabricantes = null;
    List<TipoConexionTransformador> tiposConexionTransformador = null;
    private PuntoLuz puntoLuz = new PuntoLuz();
    boolean mostrarTiposTransformador = false;

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

    public TipoConexionTransformadorFacade getTipoConexionTransformadorFacade() {
        return tipoConexionTransformadorFacade;
    }

    public void setTipoConexionTransformadorFacade(TipoConexionTransformadorFacade tipoConexionTransformadorFacade) {
        this.tipoConexionTransformadorFacade = tipoConexionTransformadorFacade;
    }

    public void setFabricanteFacade(FabricanteFacade fabricanteFacade) {
        this.fabricanteFacade = fabricanteFacade;
    }

    public TransformadorFacade getTransformadorFacade() {
        return transformadorFacade;
    }

    public void setTransformadorFacade(TransformadorFacade transformadorFacade) {
        this.transformadorFacade = transformadorFacade;
    }

    public List<TipoTransformador> getTiposTransformador() {
        return tiposTransformador;
    }

    public void setTiposTransformador(List<TipoTransformador> tiposTransformador) {
        this.tiposTransformador = tiposTransformador;
    }

    public PuntoLuz getPuntoLuz() {
        return puntoLuz;
    }

    public void setPuntoLuz(PuntoLuz puntoLuz) {
        this.puntoLuz = puntoLuz;
    }

    public boolean isMostrarTiposTransformador() {
        return mostrarTiposTransformador;
    }

    public void setMostrarTiposTransformador(boolean mostrarTiposTransformador) {
        this.mostrarTiposTransformador = mostrarTiposTransformador;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public List<TipoConexionTransformador> getTiposConexionTransformador() {
        return tiposConexionTransformador;
    }

    public void setTiposConexionTransformador(List<TipoConexionTransformador> tiposConexionTransformador) {
        this.tiposConexionTransformador = tiposConexionTransformador;
    }

    public String inicializarPunto() {
        puntoLuz = new PuntoLuz();
        
        return "pm:ubicacionpunto";
    }
    
    public String inicializarTiposTransformador() {
        tiposTransformador = new ArrayList<>();
        tiposConexionTransformador = new ArrayList<>();
        fabricantes = new ArrayList<>();

        tiposTransformador = getTipoTransformadorFacade().findAll();
        tiposConexionTransformador = getTipoConexionTransformadorFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        
        mostrarTiposTransformador = true;
        
        return "pm:transformador";
    }
}
