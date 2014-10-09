/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gaston Trujillo
 */
public abstract class JpaDAO<T> implements GenericDAO<T> {
    
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> type;

    public JpaDAO() {
       Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }
       
    @Override
        public T create(T entity) { entityManager.persist(entity); return entity; }

    @Override
	public void remove(Object id) { entityManager.remove(id); }

    @Override
	public T findById(Object id) { return entityManager.find(type, id); }
    
    @Override
	public T update(T entity) { return entityManager.merge(entity); }
        
    @Override
    public List<T> findAll() { Query query = entityManager.createQuery("SELECT a FROM T a");
                                return (List<T>)query.getResultList();}
        
    
}
