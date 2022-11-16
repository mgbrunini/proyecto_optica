package com.optica.backend.Service;

import com.optica.backend.Entity.Clientes;
import com.optica.backend.Repository.ClientesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientesService {
    @Autowired
    ClientesRepository clientesRepository;
    
    public List<Clientes> list(){
        return clientesRepository.findAll();
    }
    
    public Optional<Clientes> getOne(int id){
        return clientesRepository.findById(id);
    }
    
    public Optional<Clientes> getByNombre(String nombre){
        return clientesRepository.findByNombre(nombre);
    }
    
    public void save(Clientes clientes){
        clientesRepository.save(clientes);
    }
    
    public void delete(int id){
        clientesRepository.deleteById(id);
    }

    public Optional<Clientes> findById(int id) {
        return clientesRepository.findById(id);
    }
    
    public boolean existsById(int id){
        return clientesRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return clientesRepository.existsByNombre(nombre);
    }
    
}
