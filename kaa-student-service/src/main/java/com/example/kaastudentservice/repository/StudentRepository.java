package com.example.kaastudentservice.repository;

import com.example.kaastudentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByDocumento(String documento);
}
