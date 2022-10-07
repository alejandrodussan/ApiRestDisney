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
@Table(name="personajepeliculaoserie")
public class PersonajePeliculaOSerie implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idPersonajePeliculaOSerie")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="Personaje_idpersonaje")
    private Integer personaje;
    @ManyToOne
    @JoinColumn(name="PeliculaOSerie_idPeliculaOSerie")
    private Integer pelicula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Integer personaje) {
        this.personaje = personaje;
    }

    public Integer getPelicula() {
        return pelicula;
    }

    public void setPelicula(Integer pelicula) {
        this.pelicula = pelicula;
    }
    
    
}
