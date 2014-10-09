/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import DaoImplements.LibroDAOImpl;
import Entities.Libro;
import Services.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gaston Trujillo
 */
@Service(value = "ServiceLibroImpl")
public class ServiceLibroImpl implements LibroService{

    @Autowired
    private LibroDAOImpl libroDao;
 
    @Transactional(rollbackForClassName = "java.lang.Exception")
    @Override
    public List<Libro> findAll() {
       return libroDao.findAll();
    }
 
    @Override
    public void create(Libro libro) {
        libroDao.create(libro);
        System.out.println("inside service implementación");
    }
 
    @Override
    public Libro findById(Long id) {
       return libroDao.findById(id);
    }
 
    @Override
    public void update(Libro libro) {
       libroDao.update(libro);
    }
}
