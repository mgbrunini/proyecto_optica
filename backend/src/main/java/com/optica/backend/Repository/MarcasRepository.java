/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.optica.backend.Repository;

import com.optica.backend.Entity.Marcas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Integer>{
    public Optional<Marcas> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
