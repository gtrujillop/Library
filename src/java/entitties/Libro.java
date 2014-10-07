/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitties;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
public class Libro implements Serializable{
    @Id
    private Long id_libro;
    @Column(name= "nombre_libro") 
    private String nombre_libro;
   
    public Libro(){
       
    }
    
    public Libro(Long id_libro, String nombre_libro){
         this.id_libro = id_libro;
        this.nombre_libro = nombre_libro;
    }
   
    public Long getId_libro(){
        return id_libro;
    }
    
    public void setId_libro(Long id_libro){
        this.id_libro=id_libro;
    }
    
    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }
    
}
