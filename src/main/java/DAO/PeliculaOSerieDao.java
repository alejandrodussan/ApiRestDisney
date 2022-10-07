/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.PeliculaOSerie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josed
 */
@Repository
public interface PeliculaOSerieDao extends CrudRepository<PeliculaOSerie,Integer>{
    List<PeliculaOSerie> findByTitulo(String titulo);
    
    @Query(value="SELECT * FROM peliculaoserie p ORDER BY p.nombre ?1")
    List<PeliculaOSerie> findByOrden(String orden);
    
    @Query(value="SELECT p.titulo, p.imagen, p.fechadecreacion FROM PeliculaOSerie p")
    List<PeliculaOSerie> findShort();
}
