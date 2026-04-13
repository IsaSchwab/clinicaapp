package com.clinicaapp.backend.controller;

import com.clinicaapp.backend.dto.MedicoRequest;
import com.clinicaapp.backend.model.Medico;
import com.clinicaapp.backend.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService service;

    @GetMapping
    public ResponseEntity<List<Medico>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody @Valid MedicoRequest request) {
        return ResponseEntity.status(201).body(service.cadastrar(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medico> inativar(@PathVariable Long id) {
        return ResponseEntity.ok(service.inativar(id));
    }
}
