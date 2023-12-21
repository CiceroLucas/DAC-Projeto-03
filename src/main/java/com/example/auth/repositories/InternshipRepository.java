package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.domain.estagio.Estagio;

public interface InternshipRepository extends JpaRepository<Estagio, Long>{
    
}
