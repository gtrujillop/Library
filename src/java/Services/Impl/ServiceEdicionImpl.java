/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import DaoImplements.EdicionDAOImpl;
import Entities.Edicion;
import Services.EdicionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gaston Trujillo
 */
@Service(value = "ServiceEdicionImpl")

public class ServiceEdicionImpl implements EdicionService{
    
    @Autowired
    private EdicionDAOImpl edicionDao;
 
    @Transactional(rollbackForClassName = "java.lang.Exception")
    @Override
    public List<Edicion> findAll() {
       return edicionDao.findAll();
    }
 
    @Override
    public void create(Edicion edicion) {
        edicionDao.create(edicion);
        System.out.println("inside service implementación");
    }
 
    @Override
    public Edicion findById(Long id) {
       return edicionDao.findById(id);
    }
 
    @Override
    public void update(Edicion edicion) {
       edicionDao.update(edicion);
    }
    
}
