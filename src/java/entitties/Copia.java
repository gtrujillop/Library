/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitties;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name = "copias")
public class Copia implements Serializable{    
    @EmbeddedId CopyId id_copia;     
    @Column(name = "num_copias" )
    private Integer num_copias;
    @Column(name = "valor_multa")
    private Double valor_multa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_edicion", nullable = false, referencedColumnName = "id_edicion")
    private Edicion edicion;

    public Copia() {
    }
    
    public Copia(Integer num_copias, Double valor_multa) {
        this.num_copias = num_copias;
        this.valor_multa = valor_multa;
    } 
    

    public Integer getNum_copias() {
        return num_copias;
    }

    public void setNum_copias(Integer num_copias) {
        this.num_copias = num_copias;
    }

    public Double getValor_multa() {
        return valor_multa;
    }

    public void setValor_multa(Double valor_multa) {
        this.valor_multa = valor_multa;
    }

    public CopyId getId_copia() {
        return id_copia;
    }

    public void setId_copia(CopyId id_copia) {
        this.id_copia = id_copia;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.num_copias);
        hash = 47 * hash + Objects.hashCode(this.valor_multa);
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
        final Copia other = (Copia) obj;
       
        if (!Objects.equals(this.num_copias, other.num_copias)) {
            return false;
        }
        return Objects.equals(this.valor_multa, other.valor_multa);
    }

    @Override
    public String toString() {
        return "Copia{" + "num_copias=" + num_copias + ", valor_multa=" + valor_multa + '}';
    }
    
    
}
