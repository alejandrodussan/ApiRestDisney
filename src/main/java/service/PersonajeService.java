/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Personaje;
import org.springframework.stereotype.Service;

/**
 *
 * @author josed
 */
@Service
public interface PersonajeService {
    public List<Personaje> findAll();
    public Personaje save(Personaje personaje);
    public void deleteById(Integer id);
    public Personaje findById(Integer id);
    public List<Personaje> findByNombre(String nombre);
    public List<Personaje> findByEdad(Integer edad);
    public List<Personaje> findShort();
}
