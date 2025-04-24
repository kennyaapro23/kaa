package com.example.kaaenrollmentservice.service.impl;

import com.example.kaaenrollmentservice.entity.Enrollment;
import com.example.kaaenrollmentservice.repository.EnrollmentRepository;
import com.example.kaaenrollmentservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service

public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository repository;

    @Override
    public List<Enrollment> listar() {
        return repository.findAll();
    }

    @Override
    public Enrollment obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));
    }

    @Override
    public Enrollment registrar(Enrollment enrollment) {
        // Aquí podrías validar con Feign si el estudiante está activo y si hay capacidad
        enrollment.setFechaMatricula(LocalDate.now());
        return repository.save(enrollment);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
