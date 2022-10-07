/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author josed
 */
@Entity
@Table(name="peliculaoserie")
public class PeliculaOSerie implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idPeliculaOSerie")
    private Integer idpeliculaoserie;
    @Column(name="titulo")
    private String titulo;
    @Column(name="fechadecreacion")
    private String fecha;
    @Column(name="calificacion")
    private Integer calificacion;
    @Column(name="imagen")
    private String imagen;

    public Integer getIdpeliculaoserie() {
        return idpeliculaoserie;
    }

    public void setIdpeliculaoserie(Integer idpeliculaoserie) {
        this.idpeliculaoserie = idpeliculaoserie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
