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
import javax.persistence.Table;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    @Id
    private Long id_usuario;
    @Column(name="codigo")
    private Long codigo;
    @Column(name="password")
    private String password;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="telefono")
    private String telefono;

    public Usuario(Long id_usuario, Long codigo, String password, String first_name, String last_name, String email, String telefono) {
        this.id_usuario = id_usuario;
        this.codigo = codigo;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.telefono = telefono;
    }

    public Usuario(){
        
    }
    
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
   
    
}
