/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name="autores")
public class Autor implements Serializable{
    @Id
    @GeneratedValue(strategy=TABLE, generator="TAB_GEN")
    private Long id_autor;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthdate;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deathdate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "publicaciones",
                joinColumns ={@JoinColumn(name = "id_autor")},
                inverseJoinColumns = {@JoinColumn(name = "id_libro")}
    )
    private List<Libro> libros;
    
    public Autor(){
        
    }
    
    public Autor(Long id_autor, String first_name, String last_name,
                    Date birthdate, Date deathdate){
       this.id_autor = id_autor;
       this.first_name = first_name;
       this.last_name = last_name;
       this.birthdate = birthdate;
       this.deathdate = deathdate;
    }

    public Long getId_autor() {
        return id_autor;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(Date deathdate) {
        this.deathdate = deathdate;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id_autor);
        hash = 47 * hash + Objects.hashCode(this.first_name);
        hash = 47 * hash + Objects.hashCode(this.last_name);
        hash = 47 * hash + Objects.hashCode(this.birthdate);
        hash = 47 * hash + Objects.hashCode(this.deathdate);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id_autor, other.id_autor)) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.birthdate, other.birthdate)) {
            return false;
        }
        return Objects.equals(this.deathdate, other.deathdate);
    }

    @Override
    public String toString() {
        return "Autor{" + "id_autor=" + id_autor + ", first_name=" + first_name + ", last_name=" + last_name + ", birthdate=" + birthdate + ", deathdate=" + deathdate + ", libros=" + libros + '}';
    }    
    
}
