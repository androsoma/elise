/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.AlturaPosteFacade;
import ejb.inventario.ArrancadorFacade;
import ejb.inventario.BrazoLuminariaFacade;
import ejb.inventario.ClasePrecisionFacade;
import ejb.inventario.FabricanteFacade;
import ejb.inventario.FaseFacade;
import ejb.inventario.FrecuenciaFacade;
import ejb.inventario.MaterialPosteFacade;
import ejb.inventario.PotenciaFacade;
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
import ejb.inventario.VoltajeFacade;
import entidades.inventario.AlturaPoste;
import entidades.inventario.Arrancador;
import entidades.inventario.Balasto;
import entidades.inventario.Bombillo;
import entidades.inventario.BrazoLuminaria;
import entidades.inventario.ClasePrecision;
import entidades.inventario.Fabricante;
import entidades.inventario.Fase;
import entidades.inventario.Frecuencia;
import entidades.inventario.Luminaria;
import entidades.inventario.MaterialPoste;
import entidades.inventario.MedidorEnergia;
import entidades.inventario.Municipio;
import entidades.inventario.Poste;
import entidades.inventario.Potencia;
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
import entidades.inventario.Voltaje;
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
public class InventarioControl {

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

    @EJB
    @Inject
    BrazoLuminariaFacade brazoLuminariaFacade;

    @EJB
    @Inject
    ArrancadorFacade arrancadorFacade;

    @EJB
    @Inject
    FrecuenciaFacade frecuenciaFacade;

    @EJB
    @Inject
    VoltajeFacade voltajeFacade;

    @EJB
    @Inject
    PotenciaFacade potenciaFacade;

    @EJB
    @Inject
    FaseFacade faseFacade;

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
    List<Frecuencia> frecuencias = null;
    List<Voltaje> voltajes = null;
    List<Potencia> potencias = null;
    List<Fase> fases = null;

    private PuntoLuz puntoLuz;

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

    public BrazoLuminariaFacade getBrazoLuminariaFacade() {
        return brazoLuminariaFacade;
    }

    public void setBrazoLuminariaFacade(BrazoLuminariaFacade brazoLuminariaFacade) {
        this.brazoLuminariaFacade = brazoLuminariaFacade;
    }

    public List<TipoTransformador> getTiposTransformador() {
        return tiposTransformador;
    }

    public ArrancadorFacade getArrancadorFacade() {
        return arrancadorFacade;
    }

    public void setArrancadorFacade(ArrancadorFacade arrancadorFacade) {
        this.arrancadorFacade = arrancadorFacade;
    }

    public FrecuenciaFacade getFrecuenciaFacade() {
        return frecuenciaFacade;
    }

    public void setFrecuenciaFacade(FrecuenciaFacade frecuenciaFacade) {
        this.frecuenciaFacade = frecuenciaFacade;
    }

    public VoltajeFacade getVoltajeFacade() {
        return voltajeFacade;
    }

    public void setVoltajeFacade(VoltajeFacade voltajeFacade) {
        this.voltajeFacade = voltajeFacade;
    }

    public PotenciaFacade getPotenciaFacade() {
        return potenciaFacade;
    }

    public void setPotenciaFacade(PotenciaFacade potenciaFacade) {
        this.potenciaFacade = potenciaFacade;
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public void setFaseFacade(FaseFacade faseFacade) {
        this.faseFacade = faseFacade;
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

    public List<ClasePrecision> getClasesPrecision() {
        return clasesPrecision;
    }

    public void setClasesPrecision(List<ClasePrecision> clasesPrecision) {
        this.clasesPrecision = clasesPrecision;
    }

    public List<Frecuencia> getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(List<Frecuencia> frecuencias) {
        this.frecuencias = frecuencias;
    }

    public List<Voltaje> getVoltajes() {
        return voltajes;
    }

    public void setVoltajes(List<Voltaje> voltajes) {
        this.voltajes = voltajes;
    }

    public List<Potencia> getPotencias() {
        return potencias;
    }

    public void setPotencias(List<Potencia> potencias) {
        this.potencias = potencias;
    }

    public List<Fase> getFases() {
        return fases;
    }

    public void setFases(List<Fase> fases) {
        this.fases = fases;
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
        puntoLuz.getTransformador().setFase(new Fase());
        puntoLuz.getTransformador().setFrecuencia(new Frecuencia());
        puntoLuz.getTransformador().setPotencia(new Potencia());
        puntoLuz.getTransformador().setVoltaje(new Voltaje());

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
        puntoLuz.getLuminaria().setPotencia(new Potencia());

        puntoLuz.setBombillo(new Bombillo());
        puntoLuz.getBombillo().setFabricante(new Fabricante());
        puntoLuz.getBombillo().setTipoBombillo(new TipoBombillo());
        puntoLuz.getBombillo().setPotencia(new Potencia());
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
        puntoLuz.getMedidorEnergia().setVoltaje(new Voltaje());
        puntoLuz.getMedidorEnergia().setFrecuencia(new Frecuencia());
        puntoLuz.getMedidorEnergia().setPotenciaMaxima(new Potencia());

        return "pm:ubicacionpunto";
    }

    public String inicializarTiposTransformador() {
        System.out.println("Inicializar listas transforamdor.");
        tiposTransformador = new ArrayList<>();
        tiposConexionTransformador = new ArrayList<>();
        fabricantes = new ArrayList<>();
        frecuencias = new ArrayList<>();
        voltajes = new ArrayList<>();
        potencias = new ArrayList<>();
        fases = new ArrayList<>();

        tiposTransformador = getTipoTransformadorFacade().findAll();
        tiposConexionTransformador = getTipoConexionTransformadorFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        frecuencias = getFrecuenciaFacade().findAll();
        voltajes = getVoltajeFacade().findAll();
        potencias = getPotenciaFacade().findAll();
        fases = getFaseFacade().findAll();

        return "pm:transformador";
    }

    public String inicializarTiposLuminaria() {
        System.out.println("Inicializar listas luminaria.");
        tiposHerraje = new ArrayList<>();
        fabricantes = new ArrayList<>();
        tiposBalasto = new ArrayList<>();
        tiposProteccion = new ArrayList<>();
        tiposArrancador = new ArrayList<>();
        potencias = new ArrayList<>();

        tiposHerraje = getTipoHerrajeFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        tiposBalasto = getTipoBalastoFacade().findAll();
        tiposProteccion = getTipoProteccionFacade().findAll();
        tiposArrancador = getTipoArrancadorFacade().findAll();
        potencias = getPotenciaFacade().findAll();

        return "pm:luminaria";
    }

    public String imprimirValoresLuminaria() {
        System.out.println("Diametro brazo = " + puntoLuz.getLuminaria().getBrazoLuminaria().getDiametro());
        System.out.println("Largo brazo = " + puntoLuz.getLuminaria().getBrazoLuminaria().getLargo());
        System.out.println("Tipo balasto = " + puntoLuz.getLuminaria().getBalasto().getTipoBalasto().getId());
        System.out.println("Fabricante balasto = " + puntoLuz.getLuminaria().getBalasto().getFabricante().getId());
        System.out.println("Tipo arrancador = " + puntoLuz.getLuminaria().getArrancador().getTipoArrancador().getId());
        System.out.println("Referencia  arrancador = " + puntoLuz.getLuminaria().getArrancador().getReferencia());

        return null;
    }
    
    public String imprimirValoresTransformador() {
        System.out.println("Tipo transformador: " + puntoLuz.getTransformador().getTipoTransformador().getId());
        System.out.println("Exclusivo: " + puntoLuz.getTransformador().isExclusivo());
        System.out.println("Fase: " + puntoLuz.getTransformador().getFase().getId());
        System.out.println("Serial: " + puntoLuz.getTransformador().getSerial());     
        
        return null;
    }

    public String inicializarTiposBombillo() {
        System.out.println("Inicializar listas bombillo.");
        tiposBombillo = new ArrayList<>();
        fabricantes = new ArrayList<>();
        potencias = new ArrayList<>();
        
        tiposBombillo = getTipoBombilloFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();
        potencias = getPotenciaFacade().findAll();

        return "pm:bombillo";
    }

    public String inicializarTiposPoste() {
        System.out.println("Inicializar listas poste.");

        materialesPoste = new ArrayList<>();
        alturasPoste = new ArrayList<>();
        fabricantes = new ArrayList<>();

        materialesPoste = getMaterialPosteFacade().findAll();
        alturasPoste = getAlturaPosteFacade().findAll();
        fabricantes = getFabricanteFacade().findAll();

        return "pm:poste";
    }

    public String inicializarTiposMedidor() {
        System.out.println("Inicializar listas medidor.");

        fabricantes = new ArrayList<>();
        tiposMedidor = new ArrayList<>();
        clasesPrecision = new ArrayList<>();
        tiposConexionMedidor = new ArrayList<>();
        tiposProteccion = new ArrayList<>();
        voltajes = new ArrayList<>();
        frecuencias = new ArrayList<>();
        potencias = new ArrayList<>();

        fabricantes = getFabricanteFacade().findAll();
        tiposMedidor = getTipoMedidorFacade().findAll();
        clasesPrecision = getClasePrecisionFacade().findAll();
        tiposConexionMedidor = getTipoConexionMedidorFacade().findAll();
        tiposProteccion = getTipoProteccionFacade().findAll();
        voltajes = getVoltajeFacade().findAll();
        frecuencias = getFrecuenciaFacade().findAll();
        potencias = getPotenciaFacade().findAll();

        return "pm:medidor";
    }

    public void guardarBrazoLuminaria() {
        System.out.println("Voy a guardar brazo luminaria.");

        getBrazoLuminariaFacade().create(puntoLuz.getLuminaria().getBrazoLuminaria());
    }

    public void editarBrazoLuminaria() {
        System.out.println("Voy a editar brazo luminaria.");

        getBrazoLuminariaFacade().edit(puntoLuz.getLuminaria().getBrazoLuminaria());
    }

    public void guardarArrancador() {
        System.out.println("Voy a guardar el arrancador.");

        if (puntoLuz.getLuminaria().getArrancador().getId() == null) {
            getArrancadorFacade().create(puntoLuz.getLuminaria().getArrancador());

            System.out.println("Id del arrancador creado: " + puntoLuz.getLuminaria().getArrancador().getId());
        } else {
            getArrancadorFacade().edit(puntoLuz.getLuminaria().getArrancador());

            System.out.println("Id del arrancador editado: " + puntoLuz.getLuminaria().getArrancador().getId());
        }
    }
}
