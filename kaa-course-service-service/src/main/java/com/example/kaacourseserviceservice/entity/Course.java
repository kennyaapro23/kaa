package com.example.kaacourseserviceservice.entity;


import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;
    public String codigo; // Ejemplo: INF101
    public String horario; // Ejemplo: "Lunes 10am-12pm"
    public int capacidad;
    public int ciclo;
}
