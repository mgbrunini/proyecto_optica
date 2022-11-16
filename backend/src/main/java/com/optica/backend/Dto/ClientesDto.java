package com.optica.backend.Dto;

import com.optica.backend.Entity.Marcas;
import java.util.Date;

public class ClientesDto {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private int ojoDerecho;
    private int ojoIzquierdo;
    private Marcas marcas;
    private Date createAt;

    //Constructor

    public ClientesDto() {
    }

    public ClientesDto(String nombre, String apellido, String direccion, String telefono, int ojoDerecho, int ojoIzquierdo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ojoDerecho = ojoDerecho;
        this.ojoIzquierdo = ojoIzquierdo;
    }
    
    //Getter & Setter

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
