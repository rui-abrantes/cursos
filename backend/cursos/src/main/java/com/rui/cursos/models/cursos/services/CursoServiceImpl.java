package com.rui.cursos.models.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.rui.cursos.models.cursos.dtos.CursoRequest;
import com.rui.cursos.models.cursos.dtos.CursoSpecification;
import com.rui.cursos.models.cursos.entities.Curso;
import com.rui.cursos.models.cursos.interfaces.CursoRepository;
import com.rui.cursos.models.cursos.interfaces.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso findById(Integer id) {
        return this.cursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> findAll(CursoSpecification cursoSpecification) {

        if (cursoSpecification == null)
            return cursoRepository.findAll();

        Specification<Curso> specification = (root, query, cb) -> cb.conjunction();

        if (cursoSpecification.getName() != null && !cursoSpecification.getName().isBlank()) {
            specification = specification.and(
                    (root, query, cb) -> cb.equal(root.get("name"), cursoSpecification.getName()));
        }

        if (cursoSpecification.getCategoria() != null) {
            specification = specification.and(
                    (root, query, cb) -> cb.equal(root.get("category"), cursoSpecification.getName()));
        }

        return cursoRepository.findAll(specification);
    }

    @Override
    public Curso create(CursoRequest cursoRequest) {

        Curso curso = new Curso();

        curso.setActive(true);
        curso.setCategory(cursoRequest.getCategoria());
        curso.setName(cursoRequest.getName());

        return this.cursoRepository.save(curso);
    }

    @Override
    public Curso update(Integer id, CursoRequest cursoRequest) {
        Curso curso = findById(id);

        if (!cursoRequest.getName().isBlank())
            curso.setName(cursoRequest.getName());
        if (cursoRequest.getCategoria() != null)
            curso.setCategory(cursoRequest.getCategoria());

        return curso;
    }

    @Override
    public void delete(Integer id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public void ativarCurso(Integer id) {
        Curso curso = findById(id);

        curso.setActive(!curso.getActive());

        cursoRepository.save(curso);
    }

}
