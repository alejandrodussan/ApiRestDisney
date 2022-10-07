/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implement;

import DAO.PeliculaOSerieDao;
import java.util.List;
import model.PeliculaOSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PeliculaOSerieService;

/**
 *
 * @author josed
 */
@Service
public class PeliculaOSerieServiceImpl implements PeliculaOSerieService{
    @Autowired
    private PeliculaOSerieDao peliculadao;
    @Override
    public List<PeliculaOSerie> findAll() {
        return (List<PeliculaOSerie>) peliculadao.findAll();
    }

    @Override
    public PeliculaOSerie findById(Integer id) {
        return peliculadao.findById(id).orElse(null);
    }

    @Override
    public PeliculaOSerie save(PeliculaOSerie pelicula) {
        return peliculadao.save(pelicula);
    }

    @Override
    public void deleteById(Integer id) {
        peliculadao.deleteById(id);
    }

    @Override
    public List<PeliculaOSerie> findByTitulo(String titulo) {
        return (List<PeliculaOSerie>) peliculadao.findByTitulo(titulo);
    }

    @Override
    public List<PeliculaOSerie> findByOrden(String orden) {
        return (List<PeliculaOSerie>) peliculadao.findByOrden(orden);
    }

    @Override
    public List<PeliculaOSerie> findShort() {
        return (List<PeliculaOSerie>) peliculadao.findShort();
    }
    
}
