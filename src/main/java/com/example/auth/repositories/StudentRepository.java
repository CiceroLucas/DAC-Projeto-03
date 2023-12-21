package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.domain.aluno.Aluno;

public interface StudentRepository extends JpaRepository<Aluno, Long> {
    
}
