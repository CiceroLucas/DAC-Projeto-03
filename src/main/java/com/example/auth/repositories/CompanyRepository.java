package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.domain.empresa.Empresa;

public interface CompanyRepository extends JpaRepository<Empresa, Long>{

    
} 
