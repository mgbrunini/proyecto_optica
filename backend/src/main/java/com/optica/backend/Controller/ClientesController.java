package com.optica.backend.Controller;

import com.optica.backend.Dto.ClientesDto;
import com.optica.backend.Dto.MarcasDto;
import com.optica.backend.Entity.Clientes;
import com.optica.backend.Service.ClientesService;
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
public class ClientesController {
    @Autowired
    ClientesService clienteService;
    
    @Autowired
    MarcasService marcasService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Clientes>> list() {
        List<Clientes> list = clienteService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Clientes> getById(@PathVariable("id") int id){
        Clientes clientes = clienteService.getOne(id).get();
        return new ResponseEntity(clientes, HttpStatus.OK);
    }
    
    @DeleteMapping("/clientes/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        clienteService.delete(id);
    }

    
    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody ClientesDto clientesDto, MarcasDto marcasDto) {
        Clientes clientes = new Clientes(clientesDto.getNombre(),
                                         clientesDto.getApellido(),
                                        clientesDto.getDireccion(),
                                        clientesDto.getTelefono(),
                                        clientesDto.getOjoDerecho(),
                                        clientesDto.getOjoIzquierdo());
        
        marcasDto.setClientes((List<Clientes>) clientes);
        
        clienteService.save(clientes);
        
        return new ResponseEntity("Usuario creado", HttpStatus.OK);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ClientesDto clientesDto) {
        Clientes clientes = clienteService.getOne(id).get();
        clientes.setNombre(clientesDto.getNombre());
        clientes.setApellido(clientesDto.getApellido());
        clientes.setDireccion(clientesDto.getDireccion());
        clientes.setTelefono(clientesDto.getTelefono());
        clientes.setOjoDerecho(clientesDto.getOjoDerecho());
        clientes.setOjoIzquierdo(clientesDto.getOjoIzquierdo());
        clientes.setMarcas(clientesDto.getMarcas());
        
        clienteService.save(clientes);
        return new ResponseEntity("Cliente actualizado", HttpStatus.OK);
    }

}
