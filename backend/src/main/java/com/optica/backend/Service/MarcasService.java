/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.optica.backend.Service;

import com.optica.backend.Entity.Marcas;
import com.optica.backend.Repository.MarcasRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MarcasService {
    @Autowired
    MarcasRepository marcaRepository;
    
    public List<Marcas> list(){
        return marcaRepository.findAll();
    }
    
    public Optional<Marcas> getOne(int id){
        return marcaRepository.findById(id);
    }
    
    public Optional<Marcas> getByNombre(String nombre){
        return marcaRepository.findByNombre(nombre);
    }
    
    public void save(Marcas marcas){
        marcaRepository.save(marcas);
    }
    
    public void delete(int id){
        if(existsById(id) == true){
            marcaRepository.deleteById(id);
        }else{
            System.out.println("El ID no existe");
        }
        
    }

    public Optional<Marcas> findById(int id) {
        return marcaRepository.findById(id);
    }
        
    public boolean existsById(int id){
        return marcaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return marcaRepository.existsByNombre(nombre);
    }
}
