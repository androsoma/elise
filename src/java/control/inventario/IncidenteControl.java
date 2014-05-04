/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.PuntoLuzFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import ejb.mantenimiento.TipoIncidenteFacade;
import entidades.inventario.PuntoLuz;
import entidades.inventario.Tercero;
import entidades.mantenimiento.Ciudadano;
import entidades.mantenimiento.ReportePuntoLuz;
import entidades.mantenimiento.TipoIncidente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author desarrollo8
 */
public class IncidenteControl {

    private MapModel mapamodelo;
    private List<PuntoLuz> listapuntoluz;
    private List<TipoIncidente> listatipoincidente;
    private ReportePuntoLuz incidente;
    private Marker marcador;
    PuntoLuz puntoluzseleccionado;

    @EJB
    @Inject
    TipoIncidenteFacade tipoincdentefacade;

    @EJB
    @Inject
    PuntoLuzFacade puntoluzfacade;

    @EJB
    @Inject
    ReportePuntoLuzFacade reportepuntoluzfacade;

    /**
     * Creates a new instance of IncidenteControl
     */
    public IncidenteControl() {
        mapamodelo = new DefaultMapModel();
        listatipoincidente = new ArrayList<>();
        listapuntoluz = new ArrayList<>();
        incidente = new ReportePuntoLuz();
        incidente.setCiudadano(new Ciudadano());
        incidente.getCiudadano().setTercero(new Tercero());
        incidente.setPuntoLuz(new PuntoLuz());
        incidente.setTipoIncidente(new TipoIncidente());

    }

    public IncidenteControl(List<PuntoLuz> listapuntoluz, List<TipoIncidente> listatipoincidente, ReportePuntoLuz incidente) {
        this.listapuntoluz = listapuntoluz;
        this.listatipoincidente = listatipoincidente;
        this.incidente = incidente;
    }

    public void gardarIncdente() {

    }

    public List<PuntoLuz> getListapuntoluz() {
        return puntoluzfacade.findAll();
    }

    public void setListapuntoluz(List<PuntoLuz> listapuntoluz) {
        this.listapuntoluz = listapuntoluz;
    }

    public List<TipoIncidente> getListatipoincidente() {
        return tipoincdentefacade.findAll();
    }

    public void setListatipoincidente(List<TipoIncidente> listatipoincidente) {
        this.listatipoincidente = listatipoincidente;
    }

    public ReportePuntoLuz getIncidente() {
        return incidente;
    }

    public void setIncidente(ReportePuntoLuz incidente) {
        this.incidente = incidente;
    }

    public TipoIncidenteFacade getTipoincdentefacade() {
        return tipoincdentefacade;
    }

    public void setTipoincdentefacade(TipoIncidenteFacade tipoincdentefacade) {
        this.tipoincdentefacade = tipoincdentefacade;
    }

    public PuntoLuzFacade getPuntoluzfacade() {
        return puntoluzfacade;
    }

    public void setPuntoluzfacade(PuntoLuzFacade puntoluzfacade) {
        this.puntoluzfacade = puntoluzfacade;
    }

    public ReportePuntoLuzFacade getReportepuntoluzfacade() {
        return reportepuntoluzfacade;
    }

    public void setReportepuntoluzfacade(ReportePuntoLuzFacade reportepuntoluzfacade) {
        this.reportepuntoluzfacade = reportepuntoluzfacade;
    }

    public Marker getMarcador() {
        return marcador;
    }

    public void setMarcador(Marker marcador) {
        this.marcador = marcador;
    }

    public PuntoLuz getPuntoluzseleccionado() {
        return puntoluzseleccionado;
    }

    public void setPuntoluzseleccionado(PuntoLuz puntoluzseleccionado) {
        this.puntoluzseleccionado = puntoluzseleccionado;
    }    

    public MapModel getMapamodelo() {
        listapuntoluz = puntoluzfacade.findAll();
        for (PuntoLuz p : listapuntoluz) {
            LatLng coordenadas = new LatLng(p.getUbicacionPunto().getLatittud(), p.getUbicacionPunto().getLongitud());
            marcador = new Marker(coordenadas,p.getUbicacionPunto().getDireccion());
            marcador.setData(p);
            mapamodelo.addOverlay(marcador);
        }
        return mapamodelo;
    }

    public void setMapamodelo(MapModel mapamodelo) {
        this.mapamodelo = mapamodelo;
    }

    public void guardarIncidente() {
        incidente.setFechaIncidencia(new Date());
        incidente.setPuntoLuz(puntoluzseleccionado);
        getReportepuntoluzfacade().create(incidente);
    }

    public void marcadorSeleccionado(OverlaySelectEvent event) {
        marcador  = (Marker)  event.getOverlay();
        puntoluzseleccionado = (PuntoLuz) marcador.getData();
       
    }
}
