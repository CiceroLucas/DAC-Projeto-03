package com.example.auth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.domain.empresa.Empresa;
import com.example.auth.repositories.CompanyRepository;

@RestController
@RequestMapping("empresa")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return companyRepository.findAll();
    }

    @PostMapping
    public String criarEmpresa(@RequestBody Empresa empresa) {
        companyRepository.save(empresa);

    return "Empresa criada com sucesso: Nome: " + empresa.getNome() + ", Setor: " + empresa.getSetor() + ", Endereço: " + empresa.getEndereco();
}
}
