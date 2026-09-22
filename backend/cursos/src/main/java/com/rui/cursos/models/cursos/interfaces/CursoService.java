package com.rui.cursos.models.cursos.interfaces;

import java.util.List;

import com.rui.cursos.models.cursos.dtos.CursoRequest;
import com.rui.cursos.models.cursos.dtos.CursoSpecification;
import com.rui.cursos.models.cursos.entities.Curso;

public interface CursoService {

    Curso findById(Integer id);

    List<Curso> findAll(CursoSpecification specification);

    Curso create(CursoRequest curso);

    Curso update(Integer id, CursoRequest curso);

    void delete(Integer id);

    void ativarCurso(Integer id);
}
