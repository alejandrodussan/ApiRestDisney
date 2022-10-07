/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import model.Genero;
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
import service.GeneroService;

/**
 *
 * @author josed
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroService generoservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Genero> save(Genero genero){
        Genero g = generoservice.save(genero);
        return new ResponseEntity<>(g, HttpStatus.OK); 
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Genero> deleteById(@PathVariable Integer id){
        Genero g = generoservice.findById(id);
        if(g!=null){
            generoservice.deleteById(id);
        }else{
            return new ResponseEntity<>(g, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Genero> edit(@RequestBody Genero genero){
        Genero g = generoservice.findById(genero.getIdgenero());
        if(g!=null) {   
            g.setIdgenero(genero.getIdgenero());
            g.setImagen(genero.getImagen());
            g.setNombre(genero.getImagen());
            generoservice.save(g);
        } else{     
            return new ResponseEntity<>(g, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        return new ResponseEntity<>(g, HttpStatus.OK); 
    }
    
    @GetMapping(value="/list")
    public List<Genero> findAll(){
        return generoservice.findAll();
    }
    @GetMapping(value="/list/{id}")
    public Genero findById(@PathVariable Integer id){
        return generoservice.findById(id);
    }
    
    
    
    
    
}
