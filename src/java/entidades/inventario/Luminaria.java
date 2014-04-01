/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.inventario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Cristian Gutiérrez
 */
@Entity
public class Luminaria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "LuminariaSequence", sequenceName = "luminaria_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LuminariaSequence")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "fk_brazoluminaria", nullable = true)
    private BrazoLuminaria brazoLuminaria;
    
    @ManyToOne
    @JoinColumn(name = "fk_balasto", nullable = true)
    private Balasto balasto;
    
    @ManyToOne
    @JoinColumn(name = "fk_arrancador", nullable = true)
    private Arrancador arrancador;
    
    @ManyToOne
    @JoinColumn(name = "fk_tipoherraje", nullable = true)
    private TipoHerraje tipoHerraje;
    
    @ManyToOne
    @JoinColumn(name = "fk_fabricante", nullable = true)
    private Fabricante fabricante;
    
    @Column(nullable = true)
    private float altura;
    
    @Column(nullable = true)
    private String nivelIluminacion;
    
    @ManyToOne
    @JoinColumn(name = "fk_potencia", nullable = true)
    private Potencia potencia;
    
    @Column(nullable = true)
    private String referencia;
   
    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BrazoLuminaria getBrazoLuminaria() {
        return brazoLuminaria;
    }

    public void setBrazoLuminaria(BrazoLuminaria brazoLuminaria) {
        this.brazoLuminaria = brazoLuminaria;
    }

    public Balasto getBalasto() {
        return balasto;
    }

    public void setBalasto(Balasto balasto) {
        this.balasto = balasto;
    }

    public Arrancador getArrancador() {
        return arrancador;
    }

    public void setArrancador(Arrancador arrancador) {
        this.arrancador = arrancador;
    }

    public TipoHerraje getTipoHerraje() {
        return tipoHerraje;
    }

    public void setTipoHerraje(TipoHerraje tipoHerraje) {
        this.tipoHerraje = tipoHerraje;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNivelIluminacion() {
        return nivelIluminacion;
    }

    public void setNivelIluminacion(String nivelIluminacion) {
        this.nivelIluminacion = nivelIluminacion;
    }

    public Potencia getPotencia() {
        return potencia;
    }

    public void setPotencia(Potencia potencia) {
        this.potencia = potencia;
    }    

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Luminaria)) {
            return false;
        }
        Luminaria other = (Luminaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Luminaria[ id=" + id + " ]";
    }
    
}
