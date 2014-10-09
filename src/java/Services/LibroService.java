/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.Libro;
import java.util.List;

/**
 *
 * @author Gaston Trujillo
 */
public interface LibroService {
    public List<Libro> findAll();
 
    public void create(Libro libro);
 
    public Libro findById(Long id);
 
    public void update(Libro libro);
    
}
