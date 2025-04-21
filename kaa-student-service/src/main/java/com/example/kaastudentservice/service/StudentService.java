package com.example.kaastudentservice.service;

import com.example.kaastudentservice.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> listar();
    Student obtenerPorId(Long id);
    Student crear(Student student);
    Student actualizar(Long id, Student student);
    void eliminar(Long id);
}
