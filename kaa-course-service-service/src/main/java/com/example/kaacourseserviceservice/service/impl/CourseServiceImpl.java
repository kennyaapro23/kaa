package com.example.kaacourseserviceservice.service.impl;

import com.example.kaacourseserviceservice.entity.Course;
import com.example.kaacourseserviceservice.repository.CourseRepository;
import com.example.kaacourseserviceservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> listar() {
        return repository.findAll();
    }

    @Override
    public Course obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    @Override
    public Course crear(Course course) {
        Optional<Course> existente = repository.findByCodigo(course.codigo);
        if (existente.isPresent()) {
            throw new RuntimeException("El código del curso ya existe.");
        }
        return repository.save(course);
    }

    @Override
    public Course actualizar(Long id, Course course) {
        Course actual = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));

        actual.nombre = course.nombre;
        actual.codigo = course.codigo;
        actual.horario = course.horario;
        actual.capacidad = course.capacidad;
        actual.ciclo = course.ciclo;

        return repository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe un curso con ID: " + id);
        }
        repository.deleteById(id);
    }
}
