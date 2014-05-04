/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import ejb.inventario.PuntoLuzFacade;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author LENOVO
 */
public class MapaControl {

    private MapModel mapamodelo;
    private Marker marcador;
    private double lat;
    private double lng;

    public MapaControl() {        
    }

    public MapaControl(MapModel mapamodelo) {
        this.mapamodelo = new DefaultMapModel();
    }

    public MapModel getMapamodelo() {
        return mapamodelo;
    }

    public Marker getMarcador() {
        return marcador;
    }

    public void setMarcador(Marker marcador) {
        this.marcador = marcador;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void adicionarMarker(ActionEvent evento) {
        //es para probar que funciona la toma de datos
        System.out.println("lat: " + lat);
        System.out.println("lng:" + lng);
    }

    public void moverMarcador(MarkerDragEvent event) {
        System.out.println("ingreso al metodo");
        Marker marker;
        marker = event.getMarker();
        setLat(marker.getLatlng().getLat());
        setLng(marker.getLatlng().getLng());
    }

}
