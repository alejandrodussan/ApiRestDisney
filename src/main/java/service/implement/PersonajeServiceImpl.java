/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implement;

import DAO.PersonajeDao;
import java.util.List;
import model.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.PersonajeService;

/**
 *
 * @author josed
 */
@Service
public class PersonajeServiceImpl implements PersonajeService{
    @Autowired
    private PersonajeDao personajedao;
    @Override
    @Transactional(readOnly=true)
    public List<Personaje> findAll(){
        return (List<Personaje>) personajedao.findAll();
    }
    
    @Override
    @Transactional(readOnly=false)
    public Personaje save(Personaje personaje){
        return personajedao.save(personaje);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void deleteById(Integer id){
        personajedao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Personaje findById(Integer id){
        return personajedao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Personaje> findByNombre(String nombre){
        return (List<Personaje>) personajedao.findByNombre(nombre);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Personaje> findByEdad(Integer edad){
        return (List<Personaje>) personajedao.findByEdad(edad);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Personaje> findShort(){
        return (List<Personaje>) personajedao.findShort();
    }
    
}
