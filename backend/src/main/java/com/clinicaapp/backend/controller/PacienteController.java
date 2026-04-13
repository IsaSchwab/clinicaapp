package com.clinicaapp.backend.controller;

import com.clinicaapp.backend.dto.PacienteRequest;
import com.clinicaapp.backend.model.Paciente;
import com.clinicaapp.backend.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid PacienteRequest request) {
        return ResponseEntity.status(201).body(service.cadastrar(request));
    }
}
