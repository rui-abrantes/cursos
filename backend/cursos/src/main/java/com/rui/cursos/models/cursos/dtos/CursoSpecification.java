package com.rui.cursos.models.cursos.dtos;

import java.util.Locale.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoSpecification {
    String name;
    Category categoria;
}
