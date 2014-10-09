/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.Autor;
import java.util.List;

/**
 *
 * @author Gaston Trujillo
 */
public interface AutorService {
    
    public List<Autor> findAll();
 
    public void create(Autor autor);
 
    public Autor findById(Long id);
 
    public void update(Autor autor);
         
}
