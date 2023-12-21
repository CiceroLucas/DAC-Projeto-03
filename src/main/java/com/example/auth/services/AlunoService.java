package com.example.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.domain.aluno.Aluno;
import com.example.auth.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    StudentRepository studentRepository;

    public List<Aluno> getAllAlunos() {
        return studentRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> alunoOptional = studentRepository.findById(id);
        return alunoOptional.orElse(null);
    }

    public Aluno createAluno(Aluno aluno) {
        return studentRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno aluno) {
        Optional<Aluno> existingAlunoOptional = studentRepository.findById(id);

        if (existingAlunoOptional.isPresent()) {
            Aluno existingAluno = existingAlunoOptional.get();
            existingAluno.setNome(aluno.getNome());
            existingAluno.setCurso(aluno.getCurso());
            existingAluno.setOrientador(aluno.getOrientador());
            existingAluno.setEmpresa(aluno.getEmpresa());
            existingAluno.setEstagio(aluno.getEstagio());

            return studentRepository.save(existingAluno);
        } else {
            return null;
        }
    }

    public void deleteAluno(Long id) {
        studentRepository.deleteById(id);
    }
}
