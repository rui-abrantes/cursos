package com.rui.cursos.models.cursos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rui.cursos.models.cursos.entities.Curso;
import com.rui.cursos.models.cursos.interfaces.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public Curso findByName(@PathVariable Integer id) {
        return cursoService.findById(id);
    }

    @PostMapping
    public Curso create(@RequestBody Curso body) {

        return cursoService.create(body);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable Integer id, @RequestBody Curso body) {
        return cursoService.update(id, body);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        cursoService.delete(id);
        return "Apagou o Curso";
    }

    @PatchMapping("/{id}/active")
    public String activarCurso(@PathVariable Integer id) {
        cursoService.ativarCurso(id);
        return "Ativou o Curso";
    }
}