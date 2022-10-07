/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.PersonajePeliculaOSerie;
import org.springframework.stereotype.Service;

/**
 *
 * @author josed
 */
@Service
public interface PersonajePeliculaOSerieService {
    public List<PersonajePeliculaOSerie> findAll();
    public PersonajePeliculaOSerie save(PersonajePeliculaOSerie personajepelicula);
    public void deleteById(Integer id);
    public PersonajePeliculaOSerie findById(Integer id);
    public List<PersonajePeliculaOSerie> findByPersonajePelicula(Integer idpersonaje,Integer idpelicula);
}
