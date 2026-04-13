package com.clinicaapp.backend.service;

import com.clinicaapp.backend.dto.PacienteRequest;
import com.clinicaapp.backend.model.Paciente;
import com.clinicaapp.backend.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente nao encontrado"));
    }

    public Paciente cadastrar(PacienteRequest request) {
        if (repository.findByCpf(request.getCpf()).isPresent()) {
            throw new RuntimeException("CPF ja cadastrado");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setTelefone(request.getTelefone());
        paciente.setEmail(request.getEmail());
        paciente.setCreatedAt(LocalDateTime.now());

        return repository.save(paciente);
    }
}
