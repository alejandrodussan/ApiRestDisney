/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import model.PeliculaOSerie;
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
import service.PeliculaOSerieService;

/**
 *
 * @author josed
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value="/movie")
public class PeliculaController {
    @Autowired
    private PeliculaOSerieService peliculaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<PeliculaOSerie> save(PeliculaOSerie pelicula){
        PeliculaOSerie p = peliculaservice.save(pelicula);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<PeliculaOSerie> deleteById(@PathVariable Integer id){
        PeliculaOSerie p = peliculaservice.findById(id);
        if(p!=null){
            peliculaservice.deleteById(id);
        }else{
            return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<PeliculaOSerie> edit(@RequestBody PeliculaOSerie pelicula){
        PeliculaOSerie p = peliculaservice.findById(pelicula.getIdpeliculaoserie());
        if(p!=null){
            p.setTitulo(pelicula.getTitulo());
            p.setImagen(pelicula.getImagen());
            p.setFecha(pelicula.getFecha());
            p.setCalificacion(pelicula.getCalificacion());
            
            peliculaservice.save(p);
            
        }else{
            return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @GetMapping(value="/movies")
    public List<PeliculaOSerie> findShort(){
        return peliculaservice.findShort();
    }
    @GetMapping(value="/movies{nombre}")
    public List<PeliculaOSerie> findByTitulo(@PathVariable String titulo){
        return peliculaservice.findByTitulo(titulo);
    }
    @GetMapping(value="/movies{orden}")
    public List<PeliculaOSerie> findByOrden(@PathVariable String orden){
        return peliculaservice.findByOrden(orden);
    }
    
}
