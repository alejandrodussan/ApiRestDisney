/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.PeliculaOSerie;
import org.springframework.stereotype.Service;

/**
 *
 * @author josed
 */
@Service
public interface PeliculaOSerieService {
    public List<PeliculaOSerie> findAll();
    public PeliculaOSerie findById(Integer id);
    public PeliculaOSerie save(PeliculaOSerie pelicula);
    public void deleteById(Integer id);
    public List<PeliculaOSerie> findByTitulo(String titulo);
    public List<PeliculaOSerie> findByOrden(String orden);
    public List<PeliculaOSerie> findShort();
    
}
