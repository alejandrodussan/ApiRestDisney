/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.implement;

import DAO.GeneroDao;
import java.util.List;
import model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.GeneroService;

/**
 *
 * @author josed
 */
@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroDao generodao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Genero> findAll() {
        return (List<Genero>) generodao.findAll();
    }

    @Override
    @Transactional(readOnly=false)
    public Genero save(Genero genero) {
        return generodao.save(genero);
    }

    @Override
    public void deleteById(Integer id) {
        generodao.deleteById(id);
    }

    @Override
    public Genero findById(Integer id) {
        return generodao.findById(id).orElse(null);
    }
    
}
