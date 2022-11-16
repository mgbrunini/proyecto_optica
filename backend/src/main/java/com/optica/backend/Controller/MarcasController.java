/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.optica.backend.Controller;

import com.optica.backend.Dto.MarcasDto;
import com.optica.backend.Entity.Marcas;
import com.optica.backend.Service.MarcasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MarcasController {
    @Autowired
    MarcasService marcasService;
    
    @GetMapping("/marcas")
    public ResponseEntity<List<Marcas>> list() {
        List<Marcas> list = marcasService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/marcas/{id}")
    public ResponseEntity<Marcas> getById(@PathVariable("id") int id){
        Marcas marcas = marcasService.getOne(id).get();
        return new ResponseEntity(marcas, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        marcasService.delete(id);
    }

    
    @PostMapping("/marcas")
    public ResponseEntity<?> create(@RequestBody MarcasDto marcasDto) {
        Marcas marca = new Marcas(marcasDto.getNombre());
        
        return new ResponseEntity("Marca registrada", HttpStatus.OK);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody MarcasDto marcasDto) {
        Marcas marcas = marcasService.getOne(id).get();
        marcas.setNombre(marcasDto.getNombre());
        
        marcasService.save(marcas);
        return new ResponseEntity("Cliente actualizado", HttpStatus.OK);
    }
}
