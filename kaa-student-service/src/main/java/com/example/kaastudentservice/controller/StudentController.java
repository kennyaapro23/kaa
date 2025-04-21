package com.example.kaastudentservice.controller;

import com.example.kaastudentservice.entity.Student;
import com.example.kaastudentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Student obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Student crear(@RequestBody Student student) {
        return service.crear(student);
    }

    @PutMapping("/{id}")
    public Student actualizar(@PathVariable Long id, @RequestBody Student student) {
        return service.actualizar(id, student);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
