package com.example.kaastudentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    public String documento;  // Hacer la variable pública

    public String nombre;
    public String carrera;
    public String estado;  // activo, inactivo
    public int ciclo;
}
