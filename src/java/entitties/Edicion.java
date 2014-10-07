/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitties;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name = "ediciones")
public class Edicion {
    @Id
    private Long id_edicion;
    @Column(name="isbn")
    private String isbn;
    @Column(name="num_copias")
    private Integer num_copias;
    @Column(name="anno")
    private Date anno;
    @Column(name="paginas")
    private Integer paginas;

    public Edicion() {
    }

    public Edicion(Long id_edicion, String isbn, Integer num_copias, Date anno, Integer paginas) {
        this.id_edicion = id_edicion;
        this.isbn = isbn;
        this.num_copias = num_copias;
        this.anno = anno;
        this.paginas = paginas;
    }

    public Long getId_edicion() {
        return id_edicion;
    }

    public void setId_edicion(Long id_edicion) {
        this.id_edicion = id_edicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNum_copias() {
        return num_copias;
    }

    public void setNum_copias(Integer num_copias) {
        this.num_copias = num_copias;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
    
    
}
