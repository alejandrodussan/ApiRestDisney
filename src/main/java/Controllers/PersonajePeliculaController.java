/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import model.PersonajePeliculaOSerie;
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
import service.PersonajePeliculaOSerieService;

/**
 *
 * @author josed
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value="/charactermovie")
public class PersonajePeliculaController {
    @Autowired
    private PersonajePeliculaOSerieService personajepeliculaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<PersonajePeliculaOSerie> save(PersonajePeliculaOSerie pelicula){
        PersonajePeliculaOSerie p = personajepeliculaservice.save(pelicula);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<PersonajePeliculaOSerie> deleteById(@PathVariable Integer id){
        PersonajePeliculaOSerie p = personajepeliculaservice.findById(id);
        if(p!=null){
            personajepeliculaservice.deleteById(id);
        }else{
            return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<PersonajePeliculaOSerie> edit(@RequestBody PersonajePeliculaOSerie pelicula){
        PersonajePeliculaOSerie p = personajepeliculaservice.findById(pelicula.getId());
        if(p!=null){
            p.setPelicula(pelicula.getPelicula());
            p.setPersonaje(pelicula.getPersonaje());
            
            personajepeliculaservice.save(p);
            
        }else{
            return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @GetMapping(value="/charactersmovies{personaje}{pelicula}")
    public List<PersonajePeliculaOSerie> findByPersonajePelicula(@PathVariable Integer personaje,@PathVariable Integer pelicula){
        return personajepeliculaservice.findByPersonajePelicula(personaje, pelicula);
    }
}
