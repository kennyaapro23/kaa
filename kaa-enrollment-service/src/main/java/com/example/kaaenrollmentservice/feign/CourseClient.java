package com.example.kaaenrollmentservice.feign;

import com.example.kaaenrollmentservice.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Aquí estamos definiendo un cliente Feign para interactuar con el servicio de cursos
@FeignClient(name = "course-service", url = "http://localhost:8082") // Ajusta la URL según el servicio que tengas
public interface CourseClient {

    // Método para obtener detalles del curso
    @GetMapping("/courses/{courseId}")
    CourseDto getCourse(@PathVariable("courseId") Long courseId);  // Asegúrate de que esto exista
}
