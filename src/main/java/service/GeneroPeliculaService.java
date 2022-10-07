/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.GeneroPelicula;
import org.springframework.stereotype.Service;

/**
 *
 * @author josed
 */
@Service
public interface GeneroPeliculaService {
    public List<GeneroPelicula> findAll();
    public GeneroPelicula save(GeneroPelicula generopelicula);
    public void deleteById(Integer id);
    public GeneroPelicula findById(Integer id);
    public List<GeneroPelicula> findByGenero(Integer idpelicula,Integer idgenero);
}
