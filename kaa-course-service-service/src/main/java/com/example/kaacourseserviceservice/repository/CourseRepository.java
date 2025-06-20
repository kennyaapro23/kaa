package com.example.kaacourseserviceservice.repository;

import com.example.kaacourseserviceservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCodigo(String codigo);
}