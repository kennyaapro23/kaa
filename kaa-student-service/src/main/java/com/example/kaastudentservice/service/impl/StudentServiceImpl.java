package com.example.kaastudentservice.service.impl;

import com.example.kaastudentservice.entity.Student;
import com.example.kaastudentservice.repository.StudentRepository;
import com.example.kaastudentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> listar() {
        return repository.findAll();
    }

    @Override
    public Student obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
    }

    @Override
    public Student crear(Student student) {
        Optional<Student> existente = repository.findByDocumento(student.documento);  // acceso directo
        if (existente.isPresent()) {
            throw new RuntimeException("El documento ya está registrado.");
        }
        return repository.save(student);
    }

    @Override
    public Student actualizar(Long id, Student student) {
        Student actual = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));

        // Asignación directa sin setters
        actual.nombre = student.nombre;
        actual.carrera = student.carrera;
        actual.estado = student.estado;
        actual.ciclo = student.ciclo;

        return repository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe un estudiante con ID: " + id);
        }
        repository.deleteById(id);
    }
}
