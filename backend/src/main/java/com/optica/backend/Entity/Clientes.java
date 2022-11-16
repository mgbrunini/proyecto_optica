/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.optica.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
public class Clientes implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    private String direccion;
    private String telefono;
    private int ojoDerecho;
    private int ojoIzquierdo;
    
    @JsonIgnoreProperties({"clientes", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch=FetchType.LAZY ,cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="id_marca")
    private Marcas marcas;
    
    @Temporal(TemporalType.DATE)
    @Column(name="create_at")
    private Date createAt;

   //Pre persistencia    
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }
    
    //Constructor

    public Clientes() {
    }

    public Clientes(String nombre, String apellido, String direccion, String telefono, int ojoDerecho, int ojoIzquierdo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ojoDerecho = ojoDerecho;
        this.ojoIzquierdo = ojoIzquierdo;
    }
    
    //Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getOjoDerecho() {
        return ojoDerecho;
    }

    public void setOjoDerecho(int ojoDerecho) {
        this.ojoDerecho = ojoDerecho;
    }

    public int getOjoIzquierdo() {
        return ojoIzquierdo;
    }

    public void setOjoIzquierdo(int ojoIzquierdo) {
        this.ojoIzquierdo = ojoIzquierdo;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
}
