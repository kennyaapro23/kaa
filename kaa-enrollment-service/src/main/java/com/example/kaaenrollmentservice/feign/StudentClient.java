package com.example.kaaenrollmentservice.feign;

import com.example.kaaenrollmentservice.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "http://localhost:8081")  // Ajusta la URL si es necesario
public interface StudentClient {

    @GetMapping("/students/{studentId}")
    StudentDto getStudent(@PathVariable("studentId") Long studentId);
}
