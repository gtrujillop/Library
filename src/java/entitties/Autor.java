/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
public class Autor implements Serializable{
    @Id
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
    
    
    
}
