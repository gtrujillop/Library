/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import DaoImplements.AutorDAOImpl;
import Entities.Autor;
import Services.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gaston Trujillo
 */
@Service(value = "AutorServiceImpl")
public class ServiceAutorImpl implements AutorService{

    @Autowired
    private AutorDAOImpl autorDao;
 
    @Transactional(rollbackForClassName = "java.lang.Exception")
    @Override
    public List<Autor> findAll() {
       return autorDao.findAll();
    }
 
    @Override
    public void create(Autor autor) {
        autorDao.create(autor);
        System.out.println("inside service implementación");
    }
 
    @Override
    public Autor findById(Long id) {
       return autorDao.findById(id);
    }
 
    @Override
    public void update(Autor autor) {
       autorDao.update(autor);
    }
 
}
