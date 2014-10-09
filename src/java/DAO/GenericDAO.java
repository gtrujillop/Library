/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.List;
/**
 *
 * @author Gaston Trujillo
 */
public interface GenericDAO<T> {
        
    public T create(T entity);

    public T update(T entity);

    public void remove(Object id);

    public T findById(Object id);
    
    public List<T> findAll();

    
}
