/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.List;
import Entities.Autor;

/**
 *
 * @author Gaston Trujillo
 */
public interface AutorDAO {
    
    public List<Autor> getAllAuthors();
    public Autor getAuthor();
    public void updateAutor(Autor autor);
    public void deleteAutor(Autor autor);
    public void insertAutor(Autor autor);
    
}
