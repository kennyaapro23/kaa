package com.example.kaaenrollmentservice.service;

import com.example.kaaenrollmentservice.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> listar();
    Enrollment obtenerPorId(Long id);
    Enrollment registrar(Enrollment enrollment);
    void eliminar(Long id);
}
