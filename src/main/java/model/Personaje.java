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
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author josed
 */
@Entity
@Table(name="Personaje")
public class Personaje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpersonaje")
    private Integer idpersonaje;
    @Column(name="nombre")
    private String nombre;
    @Column(name="edad")
    private Integer edad;
    @Column(name="peso")
    private Integer peso;
    @Column(name="Historia")
    private String historia;
    @Column(name="imagen")
    private String imagen;

    public Integer getIdpersonaje() {
        return idpersonaje;
    }

    public void setIdpersonaje(Integer idpersonaje) {
        this.idpersonaje = idpersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
