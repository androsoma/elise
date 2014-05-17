/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.PuntoLuzFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import entidades.inventario.PuntoLuz;
import entidades.mantenimiento.ReportePuntoLuz;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Yeison Osorio
 */
public class AdministracionControl implements Serializable {

    private int opcion;
    private MapModel mapaModelo;
    private List<PuntoLuz> puntosLuz;
    private Marker marcadorPuntoLuz;
    private PuntoLuz puntoLuzSeleccionado;
    private List<ReportePuntoLuz> reportesIncidentes;
    private ReportePuntoLuz reporteIncidenteSeleccionado;
    private boolean  verdetallepunto =  false;
    
    @EJB
    @Inject
    private PuntoLuzFacade puntoLuzFacade;
    
    @EJB
    @Inject
    private ReportePuntoLuzFacade reportePuntoLuzFacade;
    
    

    public AdministracionControl() {
        opcion = 1;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public MapModel getMapaModelo() {
        return mapaModelo;
    }

    public void setMapaModelo(MapModel mapaModelo) {
        this.mapaModelo = mapaModelo;
    }

    public List<PuntoLuz> getPuntosLuz() {
        return puntosLuz;
    }

    public void setPuntosLuz(List<PuntoLuz> puntosLuz) {
        this.puntosLuz = puntosLuz;
    }

    public Marker getMarcadorPuntoLuz() {
        return marcadorPuntoLuz;
    }

    public PuntoLuz getPuntoLuzSeleccionado() {
        return puntoLuzSeleccionado;
    }

    public void setPuntoLuzSeleccionado(PuntoLuz puntoLuzSeleccionado) {
        this.puntoLuzSeleccionado = puntoLuzSeleccionado;
    }

    public void setMarcadorPuntoLuz(Marker marcadorPuntoLuz) {
        this.marcadorPuntoLuz = marcadorPuntoLuz;
    }

    public List<ReportePuntoLuz> getReportesIncidentes() {
        return reportesIncidentes;
    }

    public void setReportesIncidentes(List<ReportePuntoLuz> reportesIncidentes) {
        this.reportesIncidentes = reportesIncidentes;
    }

    public ReportePuntoLuz getReporteIncidenteSeleccionado() {
        return reporteIncidenteSeleccionado;
    }

    public void setReporteIncidenteSeleccionado(ReportePuntoLuz reporteIncidenteSeleccionado) {
        this.reporteIncidenteSeleccionado = reporteIncidenteSeleccionado;
    }

    public boolean isVerdetallepunto() {
        return verdetallepunto;
    }

    public void setVerdetallepunto(boolean verdetallepunto) {
        this.verdetallepunto = verdetallepunto;
    }

    public PuntoLuzFacade getPuntoLuzFacade() {
        return puntoLuzFacade;
    }

    public void setPuntoLuzFacade(PuntoLuzFacade puntoLuzFacade) {
        this.puntoLuzFacade = puntoLuzFacade;
    }

    public ReportePuntoLuzFacade getReportePuntoLuzFacade() {
        return reportePuntoLuzFacade;
    }

    public void setReportePuntoLuzFacade(ReportePuntoLuzFacade reportePuntoLuzFacade) {
        this.reportePuntoLuzFacade = reportePuntoLuzFacade;
    }

    public void cargarPuntosMapa() {
        mapaModelo = new DefaultMapModel();

        for (PuntoLuz puntoLuz : puntosLuz) {
            LatLng coordenadas = new LatLng(puntoLuz.getUbicacionPunto().getLatittud(), puntoLuz.getUbicacionPunto().getLongitud());

            marcadorPuntoLuz = new Marker(coordenadas, puntoLuz.getUbicacionPunto().getDireccion(), puntoLuz);
            mapaModelo.addOverlay(marcadorPuntoLuz);
        }
    }

    public void marcadorSeleccionado(OverlaySelectEvent puntoSeleccionado) {
        System.out.println("Marcador seleccionado.");
        marcadorPuntoLuz = (Marker) puntoSeleccionado.getOverlay();
        
        puntoLuzSeleccionado = (PuntoLuz) marcadorPuntoLuz.getData();
    }
    private void consultarTodosPuntosLuz() {
        puntosLuz = new ArrayList<>();
        puntosLuz = puntoLuzFacade.findAll();
    }

    public void inicializarAdministracion() {
        consultarTodosPuntosLuz();
        cargarPuntosMapa();
    }
    
    public void mostrarReporteIncidentes() {
        opcion = 2;
        
        reportesIncidentes = new ArrayList<>();
        reportesIncidentes = reportePuntoLuzFacade.findAll();
    }
    
    public void verDetallePuntoLuz(){    
       verdetallepunto = true; 
       System.out.println(isVerdetallepunto() );
    }
    
    public void seleccionarIncidente() {
        
    }
}
