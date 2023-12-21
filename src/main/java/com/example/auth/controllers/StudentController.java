package com.example.auth.controllers;

import com.example.auth.domain.aluno.Aluno;
import com.example.auth.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public ResponseEntity getAllAlunos() {
        List<Aluno> alunos = alunoService.getAllAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlunoById(@PathVariable Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createAluno(@RequestBody Aluno aluno) {
        Aluno createdAluno = alunoService.createAluno(aluno);
        return new ResponseEntity<>(createdAluno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno updatedAluno = alunoService.updateAluno(id, aluno);
        return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
