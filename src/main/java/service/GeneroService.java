/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Genero;
import org.springframework.stereotype.Service;

/**
 *
 * @author josed
 */
@Service
public interface GeneroService {
    public List<Genero> findAll();
    public Genero save(Genero genero);
    public void deleteById(Integer id);
    public Genero findById(Integer id);
    
}
