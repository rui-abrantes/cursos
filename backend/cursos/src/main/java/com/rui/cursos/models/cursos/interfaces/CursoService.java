package com.rui.cursos.models.cursos.interfaces;

import java.util.List;

import com.rui.cursos.models.cursos.entities.Curso;

public interface CursoService {

    Curso findById(Integer id);

    List<Curso> findAll();

    Curso create(Curso curso);

    Curso update(Integer id, Curso curso);

    void delete(Integer id);

    void ativarCurso(Integer id);
}
