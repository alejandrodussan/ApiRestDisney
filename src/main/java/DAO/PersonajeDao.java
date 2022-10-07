/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Personaje;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josed
 */
@Repository
public interface PersonajeDao extends CrudRepository<Personaje,Integer>{
    List<Personaje> findByNombre(String nombre);
    List<Personaje> findByEdad(Integer edad);
    @Query(value="SELECT p.imagen,p.nombre FROM personaje p")
    List<Personaje> findShort();
}
