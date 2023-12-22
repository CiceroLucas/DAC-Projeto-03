package com.example.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auth.domain.orientador.Orientador;
import com.example.auth.repositories.AdvisorRepository;

@RestController
@RequestMapping("orientador")
public class AdvisorController {

    @Autowired
    AdvisorRepository advisorRepository;

    @GetMapping
    public ResponseEntity getAllOrientadores() {
        Iterable<Orientador> orientadores = advisorRepository.findAll();
        return new ResponseEntity<>(orientadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrientadorById(@PathVariable Long id) {
        Orientador orientador = advisorRepository.findById(id).orElse(null);
        if (orientador != null) {
            return new ResponseEntity<>(orientador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Orientador não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity createOrientador(@RequestBody Orientador orientador) {
        Orientador createdOrientador = advisorRepository.save(orientador);
        return new ResponseEntity<>(createdOrientador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOrientador(@PathVariable Long id, @RequestBody Orientador orientador) {
        Orientador existingOrientador = advisorRepository.findById(id).orElse(null);
        if (existingOrientador != null) {
            existingOrientador.setNome(orientador.getNome());
            existingOrientador.setDepartamento(orientador.getDepartamento());

            Orientador updatedOrientador = advisorRepository.save(existingOrientador);
            return new ResponseEntity<>(updatedOrientador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Orientador não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrientador(@PathVariable Long id) {
        advisorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
