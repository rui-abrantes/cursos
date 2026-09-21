package com.rui.cursos.models.cursos.entities;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rui.cursos.models.categoria.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Categoria category;
    Boolean active;
    @CreationTimestamp
    Instant createdAt;
    @UpdateTimestamp
    Instant updatedAt;
}
