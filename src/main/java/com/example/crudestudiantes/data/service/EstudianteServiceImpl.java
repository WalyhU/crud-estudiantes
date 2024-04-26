package com.example.crudestudiantes.data.service;

import com.example.crudestudiantes.dao.EstudianteDao;
import com.example.crudestudiantes.entities.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    public Estudiante findById(Long id) {
        return estudianteDao.findById(id).orElse(null);
    }

    @Override
    public List<Estudiante> findByNombre(String nombre) {
        return estudianteDao.findByNombre(nombre);
    }

    @Override
    public void createEstudiante(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    public void modifyEstudiante(Long id, Estudiante estudiante) {
        if (estudianteDao.existsById(id)) {
            estudiante.setId(id);
            estudianteDao.save(estudiante);
        }
    }

    @Override
    public void deleteEstudiante(Long id) {
        if (estudianteDao.existsById(id)) {
            estudianteDao.deleteById(id);
        }
    }
}
