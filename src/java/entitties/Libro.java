/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitties;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
public class Libro implements Serializable{
    @Id
    private Long id;
    
    public Long getId(){
        return id;
    }
    
    public void setId(){
        this.id=id;
    }
    
}
