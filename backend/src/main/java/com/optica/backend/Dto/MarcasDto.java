package com.optica.backend.Dto;

import com.optica.backend.Entity.Clientes;
import java.util.List;

public class MarcasDto {
    private String nombre;
    private List<Clientes> clientes;

    //Cosntructor
    
    public MarcasDto() {
    }

    public MarcasDto(String nombre) {
        this.nombre = nombre;
    }
    
    //Getter & Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
    
}
