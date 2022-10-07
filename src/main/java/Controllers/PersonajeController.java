/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import model.Genero;
import model.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PersonajeService;

/**
 *
 * @author josed
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value="/personaje")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Personaje> save(Personaje personaje){
        Personaje p = personajeservice.save(personaje);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Personaje> deleteById(@PathVariable Integer id){
        Personaje p = personajeservice.findById(id);
        if(p!=null){
            personajeservice.deleteById(id);
        }else{
            return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Personaje> edit(@RequestBody Personaje personaje){
        Personaje p = personajeservice.findById(personaje.getIdpersonaje());
        if(p!=null){
            p.setNombre(personaje.getNombre());
            p.setEdad(personaje.getEdad());
            p.setPeso(personaje.getPeso());
            p.setImagen(personaje.getImagen());
            p.setHistoria(personaje.getHistoria());
            personajeservice.save(p);
            
        }else{
            return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @GetMapping(value="/characters")
    public List<Personaje> findShort(){
        return personajeservice.findShort();
    }
    
    @GetMapping(value="/characters{nombre}")
    public List<Personaje> findByNombre(@PathVariable String nombre){
        return personajeservice.findByNombre(nombre);
    }
    
    @GetMapping(value="/characters{edad}")
    public List<Personaje> findByEdad(@PathVariable Integer edad){
        return personajeservice.findByEdad(edad);
    }
    
    
    
    
    
}
