/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.GeneroPelicula;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josed
 */
@Repository
public interface GeneroPeliculaDao extends CrudRepository<GeneroPelicula,Integer>{
    @Query(value="SELECT * FROM generopeliculaoserie WHERE PeliculaOSerie_idPeliculaOSerie = ?1 AND Genero_idGenero=?2")
    List<GeneroPelicula> findByGenero(Integer idpelicula,Integer idgenero);
}
