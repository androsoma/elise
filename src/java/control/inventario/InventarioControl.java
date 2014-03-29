/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.AlturaPosteFacade;
import ejb.inventario.ClasePrecisionFacade;
import ejb.inventario.FabricanteFacade;
import ejb.inventario.MaterialPosteFacade;
import ejb.inventario.TipoArrancadorFacade;
import ejb.inventario.TipoBalastoFacade;
import ejb.inventario.TipoBombilloFacade;
import ejb.inventario.TipoConexionMedidorFacade;
import ejb.inventario.TipoConexionTransformadorFacade;
import ejb.inventario.TipoHerrajeFacade;
import ejb.inventario.TipoMedidorFacade;
import ejb.inventario.TipoProteccionFacade;
import ejb.inventario.TipoTransformadorFacade;
import ejb.inventario.TransformadorFacade;
import entidades.inventario.AlturaPoste;
import entidades.inventario.Arrancador;
import entidades.inventario.Balasto;
import entidades.inventario.Bombillo;
import entidades.inventario.BrazoLuminaria;
import entidades.inventario.ClasePrecision;
import entidades.inventario.Fabricante;
import entidades.inventario.Luminaria;
import entidades.inventario.MaterialPoste;
import entidades.inventario.MedidorEnergia;
import entidades.inventario.Municipio;
import entidades.inventario.Poste;
import entidades.inventario.PuntoLuz;
import entidades.inventario.TipoArrancador;
import entidades.inventario.TipoBalasto;
import entidades.inventario.TipoBombillo;
import entidades.inventario.TipoConexionMedidor;
import entidades.inventario.TipoConexionTransformador;
import entidades.inventario.TipoHerraje;
import entidades.inventario.TipoMedidor;
import entidades.inventario.TipoProteccion;
import entidades.inventario.TipoTransformador;
import entidades.inventario.Transformador;
import entidades.inventario.UbicacionPunto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Yeison Osorio
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
    TipoHerrajeFacade tipoHerrajeFacade;

    @EJB
    @Inject
    TipoBalastoFacade tipoBalastoFacade;

    @EJB
    @Inject
    TipoProteccionFacade tipoProteccionFacade;

    @EJB
    @Inject
    TipoArrancadorFacade tipoArrancadorFacade;

    @EJB
    @Inject
    TipoBombilloFacade tipoBombilloFacade;

    @EJB
    @Inject
    MaterialPosteFacade materialPosteFacade;

    @EJB
    @Inject
    AlturaPosteFacade alturaPosteFacade;

    @EJB
    @Inject
    TipoMedidorFacade tipoMedidorFacade;

    @EJB
    @Inject
    ClasePrecisionFacade clasePrecisionFacade;

    @EJB
    @Inject
    TipoConexionMedidorFacade tipoConexionMedidorFacade;

    @EJB
    @Inject
    TransformadorFacade transformadorFacade;

    List<TipoTransformador> tiposTransformador = null;
    List<Fabricante> fabricantes = null;
    List<TipoConexionTransformador> tiposConexionTransformador = null;
    List<TipoHerraje> tiposHerraje = null;
    List<TipoBalasto> tiposBalasto = null;
    List<TipoProteccion> tiposProteccion = null;
    List<TipoArrancador> tiposArrancador = null;
    List<TipoBombillo> tiposBombillo = null;
    List<MaterialPoste> materialesPoste = null;
    List<AlturaPoste> alturasPoste = null;
    List<TipoMedidor> tiposMedidor = null;
    List<ClasePrecision> clasesPrecision = null;
    List<TipoConexionMedidor> tiposConexionMedidor = null;

    private PuntoLuz puntoLuz;
    private boolean mostrarTiposTransformador;
    private boolean mostrarTiposLuminaria;
    private boolean mostrarTiposBombillo;
    private boolean mostrarTiposPoste;
    private boolean mostrarTiposMedidorEnergia;

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

    public TipoConexionTransformadorFacade getTipoConexionTransformadorFacade() {
        return tipoConexionTransformadorFacade;
    }

    public void setTipoConexionTransformadorFacade(TipoConexionTransformadorFacade tipoConexionTransformadorFacade) {
        this.tipoConexionTransformadorFacade = tipoConexionTransformadorFacade;
    }

    public TipoHerrajeFacade getTipoHerrajeFacade() {
        return tipoHerrajeFacade;
    }

    public void setTipoHerrajeFacade(TipoHerrajeFacade tipoHerrajeFacade) {
        this.tipoHerrajeFacade = tipoHerrajeFacade;
    }

    public TipoBalastoFacade getTipoBalastoFacade() {
        return tipoBalastoFacade;
    }

    public void setTipoBalastoFacade(TipoBalastoFacade tipoBalastoFacade) {
        this.tipoBalastoFacade = tipoBalastoFacade;
    }

    public TipoProteccionFacade getTipoProteccionFacade() {
        return tipoProteccionFacade;
    }

    public void setTipoProteccionFacade(TipoProteccionFacade tipoProteccionFacade) {
        this.tipoProteccionFacade = tipoProteccionFacade;
    }

    public TipoArrancadorFacade getTipoArrancadorFacade() {
        return tipoArrancadorFacade;
    }

    public void setTipoArrancadorFacade(TipoArrancadorFacade tipoArrancadorFacade) {
        this.tipoArrancadorFacade = tipoArrancadorFacade;
    }

    public TipoBombilloFacade getTipoBombilloFacade() {
        return tipoBombilloFacade;
    }

    public void setTipoBombilloFacade(TipoBombilloFacade tipoBombilloFacade) {
        this.tipoBombilloFacade = tipoBombilloFacade;
    }

    public MaterialPosteFacade getMaterialPosteFacade() {
        return materialPosteFacade;
    }

    public void setMaterialPosteFacade(MaterialPosteFacade materialPosteFacade) {
        this.materialPosteFacade = materialPosteFacade;
    }

    public AlturaPosteFacade getAlturaPosteFacade() {
        return alturaPosteFacade;
    }

    public void setAlturaPosteFacade(AlturaPosteFacade alturaPosteFacade) {
        this.alturaPosteFacade = alturaPosteFacade;
    }

    public TipoMedidorFacade getTipoMedidorFacade() {
        return tipoMedidorFacade;
    }

    public void setTipoMedidorFacade(TipoMedidorFacade tipoMedidorFacade) {
        this.tipoMedidorFacade = tipoMedidorFacade;
    }

    public TipoConexionMedidorFacade getTipoConexionMedidorFacade() {
        return tipoConexionMedidorFacade;
    }

    public void setTipoConexionMedidorFacade(TipoConexionMedidorFacade tipoConexionMedidorFacade) {
        this.tipoConexionMedidorFacade = tipoConexionMedidorFacade;
    }

    public ClasePrecisionFacade getClasePrecisionFacade() {
        return clasePrecisionFacade;
    }

    public void setClasePrecisionFacade(ClasePrecisionFacade clasePrecisionFacade) {
        this.clasePrecisionFacade = clasePrecisionFacade;
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

    public List<TipoHerraje> getTiposHerraje() {
        return tiposHerraje;
    }

    public void setTiposHerraje(List<TipoHerraje> tiposHerraje) {
        this.tiposHerraje = tiposHerraje;
    }

    public List<TipoBalasto> getTiposBalasto() {
        return tiposBalasto;
    }

    public void setTiposBalasto(List<TipoBalasto> tiposBalasto) {
        this.tiposBalasto = tiposBalasto;
    }

    public List<TipoProteccion> getTiposProteccion() {
        return tiposProteccion;
    }

    public void setTiposProteccion(List<TipoProteccion> tiposProteccion) {
        this.tiposProteccion = tiposProteccion;
    }

    public List<TipoArrancador> getTiposArrancador() {
        return tiposArrancador;
    }

    public void setTiposArrancador(List<TipoArrancador> tiposArrancador) {
        this.tiposArrancador = tiposArrancador;
    }

    public List<TipoBombillo> getTiposBombillo() {
        return tiposBombillo;
    }

    public void setTiposBombillo(List<TipoBombillo> tiposBombillo) {
        this.tiposBombillo = tiposBombillo;
    }

    public List<MaterialPoste> getMaterialesPoste() {
        return materialesPoste;
    }

    public void setMaterialesPoste(List<MaterialPoste> materialesPoste) {
        this.materialesPoste = materialesPoste;
    }

    public List<AlturaPoste> getAlturasPoste() {
        return alturasPoste;
    }

    public void setAlturasPoste(List<AlturaPoste> alturasPoste) {
        this.alturasPoste = alturasPoste;
    }

    public List<TipoMedidor> getTiposMedidor() {
        return tiposMedidor;
    }

    public void setTiposMedidor(List<TipoMedidor> tiposMedidor) {
        this.tiposMedidor = tiposMedidor;
    }

    public List<TipoConexionMedidor> getTiposConexionMedidor() {
        return tiposConexionMedidor;
    }

    public void setTiposConexionMedidor(List<TipoConexionMedidor> tiposConexionMedidor) {
        this.tiposConexionMedidor = tiposConexionMedidor;
    }

    public boolean isMostrarTiposTransformador() {
        return mostrarTiposTransformador;
    }

    public void setMostrarTiposTransformador(boolean mostrarTiposTransformador) {
        this.mostrarTiposTransformador = mostrarTiposTransformador;
    }

    public boolean isMostrarTiposLuminaria() {
        return mostrarTiposLuminaria;
    }

    public void setMostrarTiposLuminaria(boolean mostrarTiposLuminaria) {
        this.mostrarTiposLuminaria = mostrarTiposLuminaria;
    }

    public boolean isMostrarTiposBombillo() {
        return mostrarTiposBombillo;
    }

    public void setMostrarTiposBombillo(boolean mostrarTiposBombillo) {
        this.mostrarTiposBombillo = mostrarTiposBombillo;
    }

    public boolean isMostrarTiposPoste() {
        return mostrarTiposPoste;
    }

    public void setMostrarTiposPoste(boolean mostrarTiposPoste) {
        this.mostrarTiposPoste = mostrarTiposPoste;
    }

    public List<ClasePrecision> getClasesPrecision() {
        return clasesPrecision;
    }

    public void setClasesPrecision(List<ClasePrecision> clasesPrecision) {
        this.clasesPrecision = clasesPrecision;
    }

    public boolean isMostrarTiposMedidorEnergia() {
        return mostrarTiposMedidorEnergia;
    }

    public void setMostrarTiposMedidorEnergia(boolean mostrarTiposMedidorEnergia) {
        this.mostrarTiposMedidorEnergia = mostrarTiposMedidorEnergia;
    }

    public String inicializarPunto() {
        System.out.println("Entré a inicializar punto.");

        puntoLuz = new PuntoLuz();

        puntoLuz.setUbicacionPunto(new UbicacionPunto());
        puntoLuz.getUbicacionPunto().setMunicipio(new Municipio());

        puntoLuz.setTransformador(new Transformador());
        puntoLuz.getTransformador().setFabricante(new Fabricante());
        puntoLuz.getTransformador().setTipoTransformador(new TipoTransformador());
        puntoLuz.getTransformador().setTipoConexionTransformador(new TipoConexionTransformador());

        puntoLuz.setLuminaria(new Luminaria());
        puntoLuz.getLuminaria().setTipoHerraje(new TipoHerraje());
        puntoLuz.getLuminaria().setFabricante(new Fabricante());
        puntoLuz.getLuminaria().setBrazoLuminaria(new BrazoLuminaria());
        puntoLuz.getLuminaria().setBalasto(new Balasto());
        puntoLuz.getLuminaria().getBalasto().setFabricante(new Fabricante());
        puntoLuz.getLuminaria().getBalasto().setTipoBalasto(new TipoBalasto());
        puntoLuz.getLuminaria().getBalasto().setTipoProteccion(new TipoProteccion());
        puntoLuz.getLuminaria().setArrancador(new Arrancador());
        puntoLuz.getLuminaria().getArrancador().setFabricante(new Fabricante());
        puntoLuz.getLuminaria().getArrancador().setTipoArrancador(new TipoArrancador());

        puntoLuz.setBombillo(new Bombillo());
        puntoLuz.getBombillo().setFabricante(new Fabricante());
        puntoLuz.getBombillo().setTipoBombillo(new TipoBombillo());

        puntoLuz.setPoste(new Poste());
        puntoLuz.getPoste().setFabricante(new Fabricante());
        puntoLuz.getPoste().setAlturaPoste(new AlturaPoste());
        puntoLuz.getPoste().setMaterial(new MaterialPoste());

        puntoLuz.setMedidorEnergia(new MedidorEnergia());
        puntoLuz.getMedidorEnergia().setFabricante(new Fabricante());
        puntoLuz.getMedidorEnergia().setClasePrecision(new ClasePrecision());
        puntoLuz.getMedidorEnergia().setTipoMedidor(new TipoMedidor());
        puntoLuz.getMedidorEnergia().setTipoConexionMedidor(new TipoConexionMedidor());
        puntoLuz.getMedidorEnergia().setTipoProteccion(new TipoProteccion());

        desactivarMostrarTipos();

        return "pm:ubicacionpunto";
    }

    private void desactivarMostrarTipos() {
        mostrarTiposTransformador = false;
        mostrarTiposLuminaria = false;
        mostrarTiposBombillo = false;
        mostrarTiposPoste = false;
        mostrarTiposMedidorEnergia = false;
    }

    public String inicializarTiposTransformador() {
        if (!mostrarTiposTransformador) {
            System.out.println("Inicializar listas transforamdor.");
            tiposTransformador = new ArrayList<>();
            tiposConexionTransformador = new ArrayList<>();
            fabricantes = new ArrayList<>();

            tiposTransformador = getTipoTransformadorFacade().findAll();
            tiposConexionTransformador = getTipoConexionTransformadorFacade().findAll();
            fabricantes = getFabricanteFacade().findAll();

            mostrarTiposTransformador = true;
        }

        return "pm:transformador";
    }

    public String inicializarTiposLuminaria() {
        if (!mostrarTiposLuminaria) {
            System.out.println("Inicializar listas luminaria.");
            tiposHerraje = new ArrayList<>();
            fabricantes = new ArrayList<>();
            tiposBalasto = new ArrayList<>();
            tiposProteccion = new ArrayList<>();
            tiposArrancador = new ArrayList<>();

            tiposHerraje = getTipoHerrajeFacade().findAll();
            fabricantes = getFabricanteFacade().findAll();
            tiposBalasto = getTipoBalastoFacade().findAll();
            tiposProteccion = getTipoProteccionFacade().findAll();
            tiposArrancador = getTipoArrancadorFacade().findAll();

            mostrarTiposLuminaria = true;
        }
        
        imprimirValoresLuminaria();

        return "pm:luminaria";
    }

    public void imprimirValoresLuminaria() {
        System.out.println("Diametro brazo = " + puntoLuz.getLuminaria().getBrazoLuminaria().getDiametro());
        System.out.println("Fabricante balasto = " + puntoLuz.getLuminaria().getBalasto().getFabricante().getNombre());
    }

    public String inicializarTiposBombillo() {
        if (!mostrarTiposBombillo) {
            System.out.println("Inicializar listas bombillo.");
            tiposBombillo = new ArrayList<>();
            fabricantes = new ArrayList<>();

            tiposBombillo = getTipoBombilloFacade().findAll();
            fabricantes = getFabricanteFacade().findAll();

            mostrarTiposBombillo = true;
        }

        return "pm:bombillo";
    }

    public String inicializarTiposPoste() {
        if (!mostrarTiposPoste) {
            System.out.println("Inicializar listas poste.");

            materialesPoste = new ArrayList<>();
            alturasPoste = new ArrayList<>();
            fabricantes = new ArrayList<>();

            materialesPoste = getMaterialPosteFacade().findAll();
            alturasPoste = getAlturaPosteFacade().findAll();
            fabricantes = getFabricanteFacade().findAll();

            mostrarTiposPoste = true;
        }

        return "pm:poste";
    }

    public String inicializarTiposMedidor() {
        if (!mostrarTiposMedidorEnergia) {
            System.out.println("Inicializar listas medidor.");

            fabricantes = new ArrayList<>();
            tiposMedidor = new ArrayList<>();
            clasesPrecision = new ArrayList<>();
            tiposConexionMedidor = new ArrayList<>();
            tiposProteccion = new ArrayList<>();

            fabricantes = getFabricanteFacade().findAll();
            tiposMedidor = getTipoMedidorFacade().findAll();
            clasesPrecision = getClasePrecisionFacade().findAll();
            tiposConexionMedidor = getTipoConexionMedidorFacade().findAll();
            tiposProteccion = getTipoProteccionFacade().findAll();

            mostrarTiposMedidorEnergia = true;
        }

        return "pm:medidor";
    }
}
