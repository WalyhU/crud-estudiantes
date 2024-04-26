package com.example.crudestudiantes.data.controller;

import com.example.crudestudiantes.data.service.EstudianteService;
import com.example.crudestudiantes.entities.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.findAll();
    }

    @GetMapping("/{param}")
    public Estudiante obtenerEstudiantePorIdONombre(@PathVariable String param) {
        try {
            Long id = Long.parseLong(param);
            return estudianteService.findById(id);
        } catch (NumberFormatException e) {
            List<Estudiante> estudiantes = estudianteService.findByNombre(param);
            if (!estudiantes.isEmpty()) {
                return estudiantes.getFirst();
            } else {
                return null;
            }
        }
    }

    @PostMapping
    public void crearEstudiante(@RequestBody Estudiante estudiante) {
        estudianteService.createEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public void modificarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudianteService.modifyEstudiante(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
    }
}
