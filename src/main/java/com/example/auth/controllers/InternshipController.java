package com.example.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auth.domain.estagio.Estagio;
import com.example.auth.repositories.InternshipRepository;

@RestController
@RequestMapping("estagio")
public class InternshipController {

    @Autowired
    InternshipRepository internshipRepository;

    @GetMapping
    public ResponseEntity getAllInternships() {
        Iterable<Estagio> estagios = internshipRepository.findAll();
        return new ResponseEntity<>(estagios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getInternshipById(@PathVariable Long id) {
        Estagio estagio = internshipRepository.findById(id).orElse(null);
        if (estagio != null) {
            return new ResponseEntity<>(estagio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Estágio não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity createInternship(@RequestBody Estagio estagio) {
        Estagio createdEstagio = internshipRepository.save(estagio);
        return new ResponseEntity<>(createdEstagio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateInternship(@PathVariable Long id, @RequestBody Estagio estagio) {
        Estagio existingEstagio = internshipRepository.findById(id).orElse(null);
        if (existingEstagio != null) {
            existingEstagio.setNome(estagio.getNome());
            existingEstagio.setDataInicio(estagio.getDataInicio());
            existingEstagio.setDataFim(estagio.getDataFim());
            existingEstagio.setCargaHorariaTotal(estagio.getCargaHorariaTotal());
            existingEstagio.setStatus(estagio.getStatus());
            existingEstagio.setAluno(estagio.getAluno());
            existingEstagio.setOrientador(estagio.getOrientador());
            existingEstagio.setEmpresa(estagio.getEmpresa());

            Estagio updatedEstagio = internshipRepository.save(existingEstagio);
            return new ResponseEntity<>(updatedEstagio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Estágio não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteInternship(@PathVariable Long id) {
        internshipRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
