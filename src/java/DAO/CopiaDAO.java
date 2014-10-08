/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entities.Copia;
import java.util.List;

/**
 *
 * @author Gaston Trujillo
 */
public interface CopiaDAO {
    
    public List<Copia> getAllCopias();
    public Copia getCopia();
    public void updateCopia(Copia edicion);
    public void deleteCopia(Copia edicion);
    public void insertCopia(Copia edicion);
    
}
