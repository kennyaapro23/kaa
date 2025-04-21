package com.example.kaacourseserviceservice.service;


import com.example.kaacourseserviceservice.entity.Course;
import com.example.kaacourseserviceservice.repository.CourseRepository;

import java.util.List;

public interface CourseService
{
    List<Course> listar();
    Course obtenerPorId(Long id);
    Course crear(Course course);
    Course actualizar(Long id, Course course);
    void eliminar(Long id);
}
