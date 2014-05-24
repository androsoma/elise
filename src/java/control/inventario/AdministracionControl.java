/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.ConfiguracionFacade;
import ejb.inventario.PuntoLuzFacade;
import ejb.mantenimiento.ReportePuntoLuzFacade;
import entidades.inventario.PuntoLuz;
import entidades.mantenimiento.ReportePuntoLuz;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import org.primefaces.component.chart.CartesianChart;
import org.primefaces.component.chart.line.LineChart;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
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
    private boolean verdetallepunto = false;
    private CartesianChartModel lineChartModelo;
    private boolean incidenteadmin;
    private IncidenteControl incidentecontrol;
    private int slidpuntoluz;

    @EJB
    @Inject
    private PuntoLuzFacade puntoLuzFacade;

    @EJB
    @Inject
    private ReportePuntoLuzFacade reportePuntoLuzFacade;

    @EJB
    @Inject
    private ConfiguracionFacade configuracionFacade;

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

    public CartesianChartModel getLineChartModelo() {
        return lineChartModelo;
    }

    public void setLineChartModelo(CartesianChartModel lineChartModelo) {
        this.lineChartModelo = lineChartModelo;
    }

    public boolean isIncidenteadmin() {
        return incidenteadmin;
    }

    public void setIncidenteadmin(boolean incidenteadmin) {
        this.incidenteadmin = incidenteadmin;
    }

    public int getSlidpuntoluz() {
        return slidpuntoluz;
    }

    public void setSlidpuntoluz(int slidpuntoluz) {
        this.slidpuntoluz = slidpuntoluz;
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

    public ConfiguracionFacade getConfiguracionFacade() {
        return configuracionFacade;
    }

    public void setConfiguracionFacade(ConfiguracionFacade configuracionFacade) {
        this.configuracionFacade = configuracionFacade;
    }

    public void cargarPuntosMapa() {
        mapaModelo = new DefaultMapModel();
        String iconoLuminariaEncendida = configuracionFacade.obtenerValorConfiguracionPorNombre("marcadorLuminariaEncendida");
        String iconoLuminariaApagada = configuracionFacade.obtenerValorConfiguracionPorNombre("marcadorLuminariaApagada");
        String iconoMarcadorSinLuminaria = configuracionFacade.obtenerValorConfiguracionPorNombre("marcadorSinLuminaria");

        for (PuntoLuz puntoLuz : puntosLuz) {
            LatLng coordenadas = new LatLng(puntoLuz.getUbicacionPunto().getLatittud(), puntoLuz.getUbicacionPunto().getLongitud());

            marcadorPuntoLuz = new Marker(coordenadas, puntoLuz.getUbicacionPunto().getDireccion(), puntoLuz);
            if (puntoLuz.getLuminaria() != null) {
                if (puntoLuz.getLuminaria().isEncendida()) {
                    marcadorPuntoLuz.setIcon(iconoLuminariaEncendida);
                } else {
                    marcadorPuntoLuz.setIcon(iconoLuminariaApagada);
                }
            } else {
                marcadorPuntoLuz.setIcon(iconoMarcadorSinLuminaria);
            }

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
        setIncidenteadmin(true);
        opcion = 1;
        consultarTodosPuntosLuz();
        cargarPuntosMapa();
        cargarGraficoMedicionesLuminaria();
    }

    public void mostrarReporteIncidentes() {
        opcion = 2;

        reportesIncidentes = new ArrayList<>();
        reportesIncidentes = reportePuntoLuzFacade.consultarPorEstadoReportado();
    }

    public void verDetallePuntoLuz() {

        verdetallepunto = true;

    }

    public void esconderDetalle() {
        verdetallepunto = false;
    }

    public void seleccionarIncidente() {

    }

    public void cargarGraficoMedicionesLuminaria() {
        lineChartModelo = new CartesianChartModel();

        ChartSeries voltaje = new ChartSeries();
        voltaje.setLabel("Voltaje");
        voltaje.set("Ene-2014", 1100);
        voltaje.set("Feb-2014", 1117);
        voltaje.set("Mar-2014", 1095);
        voltaje.set("Abr-2014", 1102);

        ChartSeries corriente = new ChartSeries();
        corriente.setLabel("Corriente");
        corriente.set("Ene-2014", 110);
        corriente.set("Feb-2014", 105);
        corriente.set("Mar-2014", 100);
        corriente.set("Abr-2014", 108);

        ChartSeries cosenoPhi = new ChartSeries();
        cosenoPhi.setLabel("Coseno Phi");
        cosenoPhi.set("Ene-2014", 60);
        cosenoPhi.set("Feb-2014", 58);
        cosenoPhi.set("Mar-2014", 55);
        cosenoPhi.set("Abr-2014", 56);

        lineChartModelo.addSeries(voltaje);
        lineChartModelo.addSeries(corriente);
        lineChartModelo.addSeries(cosenoPhi);

    }

    public void cambioLuzPuntoSelect() {
        for (Marker m : getMapaModelo().getMarkers()) {
            if (m.getTitle().equals(puntoLuzSeleccionado.getUbicacionPunto().getDireccion())) {
                if (getSlidpuntoluz() >= 0 && getSlidpuntoluz() <= 49) {
                    String iconomarcadorLuminariaMitad = configuracionFacade.obtenerValorConfiguracionPorNombre("marcadorLuminariaApagada");
                    m.setIcon(iconomarcadorLuminariaMitad);
//                getMapaModelo().addOverlay(m);
                } else {
                    String iconomarcadorLuminariaMitad = configuracionFacade.obtenerValorConfiguracionPorNombre("marcadorLuminariaEncendida");
                    m.setIcon(iconomarcadorLuminariaMitad);

                }
            }
        }
    }

}
