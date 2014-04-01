/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elise;

import ejb.inventario.ArrancadorFacade;
import ejb.inventario.BrazoLuminariaFacade;
import ejb.inventario.FabricanteFacade;
import ejb.inventario.TipoArrancadorFacade;
import ejb.inventario.UsuarioFacade;
import entidades.inventario.Arrancador;
import entidades.inventario.BrazoLuminaria;
import entidades.inventario.Fabricante;
import entidades.inventario.Luminaria;
import entidades.inventario.PuntoLuz;
import entidades.inventario.TipoArrancador;
import entidades.inventario.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Yeison Osorio
 */
public class Autenticacion {

    @Inject
    private UsuarioFacade usuarioFacade;

    @Inject
    private BrazoLuminariaFacade brazoLuminariaFacade;
    
    @Inject
    private TipoArrancadorFacade tipoArrancadorFacade;

    private Usuario usuario = new Usuario();
    private BrazoLuminaria brazoLuminaria = new BrazoLuminaria();
    private TipoArrancador tipoArrancador = new TipoArrancador();
    private List<TipoArrancador> tiposArrancador = new ArrayList<>();
    private String opcionSeleccionada;

    /**
     * Creates a new instance of Autenticacion
     */
    public Autenticacion() {
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public BrazoLuminariaFacade getBrazoLuminariaFacade() {
        return brazoLuminariaFacade;
    }

    public void setBrazoLuminariaFacade(BrazoLuminariaFacade brazoLuminariaFacade) {
        this.brazoLuminariaFacade = brazoLuminariaFacade;
    }

    public TipoArrancadorFacade getTipoArrancadorFacade() {
        return tipoArrancadorFacade;
    }

    public void setTipoArrancadorFacade(TipoArrancadorFacade tipoArrancadorFacade) {
        this.tipoArrancadorFacade = tipoArrancadorFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BrazoLuminaria getBrazoLuminaria() {
        return brazoLuminaria;
    }

    public void setBrazoLuminaria(BrazoLuminaria brazoLuminaria) {
        this.brazoLuminaria = brazoLuminaria;
    }

    public List<TipoArrancador> getTiposArrancador() {
        return tiposArrancador;
    }

    public void setTiposArrancador(List<TipoArrancador> tiposArrancador) {
        this.tiposArrancador = tiposArrancador;
    }

    public String getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public void inicializarBrazoLuminaria() {
        brazoLuminaria = new BrazoLuminaria();
        tipoArrancador = new TipoArrancador();
        tiposArrancador = new ArrayList<>();
        tiposArrancador = tipoArrancadorFacade.findAll();
        
        opcionSeleccionada = "0";
    }

    public TipoArrancador getTipoArrancador() {
        return tipoArrancador;
    }

    public void setTipoArrancador(TipoArrancador tipoArrancador) {
        this.tipoArrancador = tipoArrancador;
    }

    public void guardarBrazoLuminaria() {
        System.out.println("Tipo arrancador: " + tipoArrancador.getId());
        
        //getBrazoLuminariaFacade().create(brazoLuminaria);
    }
    
    public String mostrarDatos() {
        System.out.println("Largo = " + brazoLuminaria.getLargo());
        System.out.println("Diámetro = " + brazoLuminaria.getDiametro());
        System.out.println("opcion seleccionada= " + getTipoArrancador().getId());
        System.out.println("opcion seleccionada= " + getTipoArrancador().getDescripcion());
        
        return null;
    }

    public String validarUsuario() {
        if (usuario.getNombreUsuario().compareTo("yosorio") == 0) {
            System.out.println("Nombre de usuario: " + usuario.getNombreUsuario());
            return "pm:menuprincipal";
        } else {
            return "pm:main";
        }
    }
    public void pruebaSeleccionada(){
        System.out.println("ingreso al metod");
        System.out.println("opcion seleccionada= " + getTipoArrancador().getId());
        System.out.println("opcion seleccionada= " + getTipoArrancador().getDescripcion());
    }
}
