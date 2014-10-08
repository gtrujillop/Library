/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name="libros")
public class Libro implements Serializable{
    @Id
    @GeneratedValue(strategy=TABLE, generator="TAB_GEN")
    private Long id_libro;
    @Column(name= "nombre_libro") 
    private String nombre_libro;
    @ManyToMany(mappedBy = "libros", cascade = CascadeType.ALL)
    private List<Autor> autores;
    @OneToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Edicion> ediciones;
   
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(List<Edicion> ediciones) {
        this.ediciones = ediciones;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.id_libro, other.id_libro)) {
            return false;
        }
        return Objects.equals(this.nombre_libro, other.nombre_libro);
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", nombre_libro=" + nombre_libro + '}';
    }
    
}
