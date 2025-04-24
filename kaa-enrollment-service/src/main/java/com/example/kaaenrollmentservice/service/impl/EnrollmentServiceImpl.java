package com.example.kaaenrollmentservice.service.impl;

import com.example.kaaenrollmentservice.dto.CourseDto;
import com.example.kaaenrollmentservice.dto.StudentDto;
import com.example.kaaenrollmentservice.entity.Enrollment;
import com.example.kaaenrollmentservice.feign.CourseClient;
import com.example.kaaenrollmentservice.feign.StudentClient;  // Añadir el cliente Feign para obtener estudiantes
import com.example.kaaenrollmentservice.repository.EnrollmentRepository;
import com.example.kaaenrollmentservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseClient courseClient;  // Feign Client para obtener detalles del curso

    @Autowired
    private StudentClient studentClient;  // Feign Client para obtener detalles del estudiante

    @Override
    public CourseDto getCourseDetails(Long courseId) {
        // Usamos el Feign Client para obtener los detalles del curso
        return courseClient.getCourse(courseId);
    }

    @Override
    public List<StudentDto> getStudentsByCourse(Long courseId) {
        // Obtener las matrículas para el curso
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);

        List<StudentDto> students = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            StudentDto student = studentClient.getStudent(enrollment.getStudentId());  // Usamos el Feign Client para obtener detalles del estudiante
            students.add(student);
        }
        return students;
    }

    // Métodos CRUD
    @Override
    public List<Enrollment> listar() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment obtenerPorId(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public Enrollment registrar(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void eliminar(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
