/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import model.GeneroPelicula;
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
import service.GeneroPeliculaService;

/**
 *
 * @author josed
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value="gendermovie")
public class GeneroPeliculaController {
    @Autowired
    private GeneroPeliculaService generopeliculaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<GeneroPelicula> save(GeneroPelicula genero){
        GeneroPelicula g = generopeliculaservice.save(genero);
        return new ResponseEntity<>(g, HttpStatus.OK); 
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<GeneroPelicula> deleteById(@PathVariable Integer id){
        GeneroPelicula g = generopeliculaservice.findById(id);
        if(g!=null){
            generopeliculaservice.deleteById(id);
        }else{
            return new ResponseEntity<>(g, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<GeneroPelicula> edit(@RequestBody GeneroPelicula genero){
        GeneroPelicula g = generopeliculaservice.findById(genero.getId());
        if(g!=null) {   
            g.setIdgenero(genero.getIdgenero());
            g.setIdpelicula(genero.getIdpelicula());

            generopeliculaservice.save(g);
        } else{     
            return new ResponseEntity<>(g, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        return new ResponseEntity<>(g, HttpStatus.OK); 
    }
    
    @GetMapping(value="/list")
    public List<GeneroPelicula> findAll(){
        return generopeliculaservice.findAll();
    }
    @GetMapping(value="/list{pelicula}{genero}")
    public List<GeneroPelicula> findByGenero(@PathVariable Integer pelicula,@PathVariable Integer genero){
        return generopeliculaservice.findByGenero(pelicula, genero);
    }
}
