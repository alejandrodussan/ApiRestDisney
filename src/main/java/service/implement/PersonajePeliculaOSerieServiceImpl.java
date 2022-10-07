/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implement;

import DAO.PersonajePeliculaOSerieDao;
import java.util.List;
import model.PersonajePeliculaOSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.PersonajePeliculaOSerieService;

/**
 *
 * @author josed
 */
@Service
public class PersonajePeliculaOSerieServiceImpl implements PersonajePeliculaOSerieService{
    @Autowired
    private PersonajePeliculaOSerieDao personajepeliculadao;
    
    @Override
    @Transactional(readOnly=true)
    public List<PersonajePeliculaOSerie> findAll() {
        return (List<PersonajePeliculaOSerie>) personajepeliculadao.findAll();
    }

    @Override
    public PersonajePeliculaOSerie save(PersonajePeliculaOSerie personajepelicula) {
        return personajepeliculadao.save(personajepelicula);
    }

    @Override
    public void deleteById(Integer id) {
        personajepeliculadao.deleteById(id);
    }

    @Override
    public PersonajePeliculaOSerie findById(Integer id) {
        return personajepeliculadao.findById(id).orElse(null);
    }

    @Override
    public List<PersonajePeliculaOSerie> findByPersonajePelicula(Integer idpersonaje, Integer idpelicula) {
        return (List<PersonajePeliculaOSerie>) personajepeliculadao.findByPersonajePelicula(idpersonaje, idpelicula);
    }
    
}
