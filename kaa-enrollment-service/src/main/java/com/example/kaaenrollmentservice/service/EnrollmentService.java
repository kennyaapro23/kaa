package com.example.kaaenrollmentservice.service;

import com.example.kaaenrollmentservice.dto.CourseDto;
import com.example.kaaenrollmentservice.dto.StudentDto;
import com.example.kaaenrollmentservice.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> listar();
    Enrollment obtenerPorId(Long id);
    Enrollment registrar(Enrollment enrollment);
    void eliminar(Long id);
    CourseDto getCourseDetails(Long courseId);  // Este método debe estar presente
    List<StudentDto> getStudentsByCourse(Long courseId);  // Este método debe estar presente
}
