package com.example.kaaenrollmentservice.controller;

import com.example.kaaenrollmentservice.entity.Enrollment;
import com.example.kaaenrollmentservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @GetMapping
    public List<Enrollment> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Enrollment obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Enrollment registrar(@RequestBody Enrollment enrollment) {
        return service.registrar(enrollment);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}