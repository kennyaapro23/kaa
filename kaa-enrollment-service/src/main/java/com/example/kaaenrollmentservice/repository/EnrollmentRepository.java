package com.example.kaaenrollmentservice.repository;

import com.example.kaaenrollmentservice.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
