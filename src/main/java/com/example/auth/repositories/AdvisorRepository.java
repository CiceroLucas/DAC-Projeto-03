package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.domain.orientador.Orientador;

public interface AdvisorRepository extends JpaRepository<Orientador, Long> {
    
}
