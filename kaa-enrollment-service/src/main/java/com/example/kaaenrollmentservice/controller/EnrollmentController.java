package com.example.kaaenrollmentservice.controller;

import com.example.kaaenrollmentservice.dto.CourseDto;
import com.example.kaaenrollmentservice.dto.StudentDto;
import com.example.kaaenrollmentservice.entity.Enrollment;
import com.example.kaaenrollmentservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    // Obtener la lista de todas las matrículas
    @GetMapping
    public List<Enrollment> listar() {
        return service.listar();
    }

    // Obtener matrícula por ID
    @GetMapping("/{id}")
    public Enrollment obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // Registrar una nueva matrícula
    @PostMapping
    public Enrollment registrar(@RequestBody Enrollment enrollment) {
        return service.registrar(enrollment);
    }

    // Eliminar una matrícula por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // Obtener detalles de un curso
    @GetMapping("/course/{courseId}")
    public CourseDto getCourseDetails(@PathVariable Long courseId) {
        // Asegúrate de que este método esté bien implementado en el servicio
        return service.getCourseDetails(courseId);
    }

    // Obtener estudiantes matriculados en un curso
    @GetMapping("/course/{courseId}/students")
    public List<StudentDto> getStudentsByCourse(@PathVariable Long courseId) {
        // Asegúrate de que el servicio devuelve la lista de estudiantes correctamente
        return service.getStudentsByCourse(courseId);
    }
}
