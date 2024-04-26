package com.example.crudestudiantes.dao;

import com.example.crudestudiantes.entities.Estudiante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstudianteDao extends CrudRepository<Estudiante, Long> {
    List<Estudiante> findByNombre(String nombre);
}
