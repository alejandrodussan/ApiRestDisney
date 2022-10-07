/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.PersonajePeliculaOSerie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josed
 */
@Repository
public interface PersonajePeliculaOSerieDao extends CrudRepository<PersonajePeliculaOSerie,Integer>{
    @Query(value="SELECT * FROM personajepeliculaoserie WHERE Personaje_idpersonaje = ?1 AND PeliculaOSerie_idPeliculaOSerie = ?2")
    List<PersonajePeliculaOSerie> findByPersonajePelicula(Integer idpersonaje,Integer idpelicula);
}
