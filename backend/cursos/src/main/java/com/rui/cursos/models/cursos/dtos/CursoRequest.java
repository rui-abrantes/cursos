package com.rui.cursos.models.cursos.dtos;

import com.rui.cursos.models.categoria.enums.Categoria;

import lombok.Data;

@Data
public class CursoRequest {
    String name;
    Categoria categoria;
}
