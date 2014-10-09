/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.Edicion;
import java.util.List;

/**
 *
 * @author Gaston Trujillo
 */
public interface EdicionService {
    
    public List<Edicion> findAll();
 
    public void create(Edicion edicion);
 
    public Edicion findById(Long id);
 
    public void update(Edicion edicion);
    
}
