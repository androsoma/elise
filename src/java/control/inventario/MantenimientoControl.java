/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.mantenimiento.AccionCierreFacade;
import ejb.mantenimiento.AccionCierreReporteFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import entidades.mantenimiento.AccionCierre;
import entidades.mantenimiento.AccionCierreReporte;
import entidades.mantenimiento.ReportePuntoLuz;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class MantenimientoControl {

    private List<String> reportes = null;
    private List<ReportePuntoLuz> incidentes = null;
    private ReportePuntoLuz reportePuntoLuzSeleccionado = new ReportePuntoLuz();
    private List<AccionCierre> accionesCierreDisponibles = null;
    private List<String> accionesSeleccionadas = new ArrayList<>();
    private String[] accionesCierreSeleccionadas = new String[] {};
    private List<AccionCierreReporte> accionesCierreReporte = null;

    @EJB
    @Inject
    private ReportePuntoLuzFacade reportePuntoLuzFacade;

    @EJB
    @Inject
    private AccionCierreFacade accionCierreFacade;

    @EJB
    @Inject
    private AccionCierreReporteFacade accionCierreReporteFacade;

    /**
     * Creates a new instance of MantenimientoControl
     */
    public MantenimientoControl() {
    }

    public List<String> getReportes() {
        return reportes;
    }

    public void setReportes(List<String> reportes) {
        this.reportes = reportes;
    }

    public List<ReportePuntoLuz> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<ReportePuntoLuz> incidentes) {
        this.incidentes = incidentes;
    }

    public ReportePuntoLuz getReportePuntoLuzSeleccionado() {
        return reportePuntoLuzSeleccionado;
    }

    public void setReportePuntoLuzSeleccionado(ReportePuntoLuz reportePuntoLuzSeleccionado) {
        this.reportePuntoLuzSeleccionado = reportePuntoLuzSeleccionado;
    }

    public ReportePuntoLuzFacade getReportePuntoLuzFacade() {
        return reportePuntoLuzFacade;
    }

    public void setReportePuntoLuzFacade(ReportePuntoLuzFacade reportePuntoLuzFacade) {
        this.reportePuntoLuzFacade = reportePuntoLuzFacade;
    }

    public List<AccionCierre> getAccionesCierreDisponibles() {
        return accionesCierreDisponibles;
    }

    public void setAccionesCierreDisponibles(List<AccionCierre> accionesCierreDisponibles) {
        this.accionesCierreDisponibles = accionesCierreDisponibles;
    }

    public List<String> getAccionesSeleccionadas() {
        return accionesSeleccionadas;
    }

    public void setAccionesSeleccionadas(List<String> accionesSeleccionadas) {
        this.accionesSeleccionadas = accionesSeleccionadas;
    }

    public String[] getAccionesCierreSeleccionadas() {
        return accionesCierreSeleccionadas;
    }

    public void setAccionesCierreSeleccionadas(String[] accionesCierreSeleccionadas) {
        this.accionesCierreSeleccionadas = accionesCierreSeleccionadas;
    }

    public List<AccionCierreReporte> getAccionesCierreReporte() {
        return accionesCierreReporte;
    }

    public void setAccionesCierreReporte(List<AccionCierreReporte> accionesCierreReporte) {
        this.accionesCierreReporte = accionesCierreReporte;
    }

    public AccionCierreFacade getAccionCierreFacade() {
        return accionCierreFacade;
    }

    public void setAccionCierreFacade(AccionCierreFacade accionCierreFacade) {
        this.accionCierreFacade = accionCierreFacade;
    }

    public AccionCierreReporteFacade getAccionCierreReporteFacade() {
        return accionCierreReporteFacade;
    }

    public void setAccionCierreReporteFacade(AccionCierreReporteFacade accionCierreReporteFacade) {
        this.accionCierreReporteFacade = accionCierreReporteFacade;
    }

    public void generarReportes() {
        reportes = new ArrayList<>();
        incidentes = new ArrayList<>();

        incidentes = reportePuntoLuzFacade.findAll();

        reportes.add("[Daño lámpara] Carrera 2 19-13, Manizales");
        reportes.add("[Robo cables] Carrera 23 68-15, Manizales");
        reportes.add("[Daño sensor] Calle 45 37B-60, Manizales");
        reportes.add("[Daño poste] Av. Santander Calle 55, Manizales");
    }

    public void seleccionarIncidente(ReportePuntoLuz incidenteSelccionado) {
        reportePuntoLuzSeleccionado = incidenteSelccionado;
    }

    public void cargarAccionesCierre() {
        accionesCierreDisponibles = new ArrayList<>();
        accionesCierreDisponibles = accionCierreFacade.findAll();

        accionesCierreReporte = new ArrayList<>();
    }

    public void cerrarReporte() {
        for (String accionCierre : accionesSeleccionadas) {
            AccionCierreReporte accionCierreReporte = new AccionCierreReporte();
            
            accionCierreReporte.setAccionCierre(accionCierreFacade.find(Long.valueOf(accionCierre)));
            accionCierreReporte.setFechaRegistro(new Date());

            accionesCierreReporte.add(accionCierreReporte);
        }
    }
    
    public void imprimirSeleccionadas() {
        for (String accion : accionesCierreSeleccionadas) {
            System.out.println("Acción seleccionada: " + accion);
        }
    }

}
