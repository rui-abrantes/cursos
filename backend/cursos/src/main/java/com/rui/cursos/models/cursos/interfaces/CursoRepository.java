package com.rui.cursos.models.cursos.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rui.cursos.models.cursos.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>,
        JpaSpecificationExecutor<Curso> {

}
