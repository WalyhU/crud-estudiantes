package com.example.crudestudiantes.data.service;

import com.example.crudestudiantes.entities.Estudiante;

import java.util.List;

public interface EstudianteService {
    public List<Estudiante> findAll();
    public Estudiante findById(Long id);
    public List<Estudiante> findByNombre(String nombre);
    public void createEstudiante(Estudiante estudiante);
    public void modifyEstudiante(Long id, Estudiante estudiante);
    public void deleteEstudiante(Long id);
}
