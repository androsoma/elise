/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.inventario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MantenimientoControl {

    private List<String> reportes = null;

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

    public void generarReportes() {
        reportes = new ArrayList<>();
        
        reportes.add("[Daño lámpara] Carrera 2 19-13, Manizales");
        reportes.add("[Robo cables] Carrera 23 68-15, Manizales");
        reportes.add("[Daño sensor] Calle 45 37B-60, Manizales");
        reportes.add("[Daño poste] Av. Santander Calle 55, Manizales");       
    }

}
