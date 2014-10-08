/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitties;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Gaston Trujillo
 */
@Embeddable
public class CopyId implements Serializable {
    public Long id_copia;
    public Long id_edicion;
    
}
