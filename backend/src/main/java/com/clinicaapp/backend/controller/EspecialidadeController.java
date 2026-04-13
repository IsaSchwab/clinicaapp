package com.clinicaapp.backend.controller;

import com.clinicaapp.backend.dto.EspecialidadeRequest;
import com.clinicaapp.backend.model.Especialidade;
import com.clinicaapp.backend.service.EspecialidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService service;

    @GetMapping
    public ResponseEntity<List<Especialidade>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Especialidade> cadastrar(@RequestBody @Valid EspecialidadeRequest request) {
        return ResponseEntity.status(201).body(service.cadastrar(request));
    }
}
