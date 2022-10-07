/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implement;

import DAO.GeneroPeliculaDao;
import java.util.List;
import model.GeneroPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.GeneroPeliculaService;

/**
 *
 * @author josed
 */
@Service
public class GeneroPeliculaServiceImpl implements GeneroPeliculaService{
    @Autowired
    private GeneroPeliculaDao generopeliculadao;
    
    @Override
    @Transactional(readOnly=true)
    public List<GeneroPelicula> findAll() {
        return (List<GeneroPelicula>) generopeliculadao.findAll();
    }

    @Override
    @Transactional(readOnly=false)
    public GeneroPelicula save(GeneroPelicula generopelicula) {
        return generopeliculadao.save(generopelicula);

    }

    @Override
    @Transactional(readOnly=false)
    public void deleteById(Integer id) {
        generopeliculadao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public GeneroPelicula findById(Integer id) {
        return generopeliculadao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<GeneroPelicula> findByGenero(Integer idpelicula, Integer idgenero) {
        return (List<GeneroPelicula>) generopeliculadao.findByGenero(idpelicula, idgenero);
    }
    
}
