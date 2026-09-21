package com.rui.cursos.models.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rui.cursos.models.cursos.entities.Curso;
import com.rui.cursos.models.cursos.interfaces.CursoRepository;
import com.rui.cursos.models.cursos.interfaces.CursoService;

public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso findById(Integer id) {
        return this.cursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> findAll() {
        return List.of();
    }

    @Override
    public Curso create(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @Override
    public Curso update(Integer id, Curso curso) {
        return new Curso();
    }

    @Override
    public void delete(Integer id) {
        return;
    }

    @Override
    public void ativarCurso(Integer id) {
        return;
    }

}
