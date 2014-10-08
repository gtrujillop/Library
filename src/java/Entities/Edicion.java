/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name = "ediciones")
public class Edicion {
    @Id
    @GeneratedValue(strategy=TABLE, generator="TAB_GEN")
    private Long id_edicion;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "num_copias")
    private Integer num_copias;
    @Column(name = "anno")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anno;
    @Column(name = "paginas")
    private Integer paginas;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_libro") 
    private Libro libro;
    @OneToMany(mappedBy = "copias", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Copia> copias;


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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Copia> getCopias() {
        return copias;
    }

    public void setCopias(List<Copia> copias) {
        this.copias = copias;
    }
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id_edicion);
        hash = 53 * hash + Objects.hashCode(this.isbn);
        hash = 53 * hash + Objects.hashCode(this.num_copias);
        hash = 53 * hash + Objects.hashCode(this.anno);
        hash = 53 * hash + Objects.hashCode(this.paginas);
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
        final Edicion other = (Edicion) obj;
        if (!Objects.equals(this.id_edicion, other.id_edicion)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.num_copias, other.num_copias)) {
            return false;
        }
        if (!Objects.equals(this.anno, other.anno)) {
            return false;
        }
        return Objects.equals(this.paginas, other.paginas);
    }

    @Override
    public String toString() {
        return "Edicion{" + "id_edicion=" + id_edicion + ", isbn=" + isbn + ", num_copias=" + num_copias + ", anno=" + anno + ", paginas=" + paginas + '}';
    }
       
}
