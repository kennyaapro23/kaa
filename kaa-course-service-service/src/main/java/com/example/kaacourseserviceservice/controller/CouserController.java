package com.example.kaacourseserviceservice.controller;

import com.example.kaacourseserviceservice.entity.Course;
import com.example.kaacourseserviceservice.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")

public class CouserController {
    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Course obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Course crear(@RequestBody Course course) {
        return service.crear(course);
    }

    @PutMapping("/{id}")
    public Course actualizar(@PathVariable Long id, @RequestBody Course course) {
        return service.actualizar(id, course);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

