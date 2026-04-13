package com.clinicaapp.backend.service;

import com.clinicaapp.backend.dto.MedicoRequest;
import com.clinicaapp.backend.model.Medico;
import com.clinicaapp.backend.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository repository;

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico nao encontrado"));
    }

    public Medico cadastrar(MedicoRequest request) {
        if (repository.findByCrm(request.getCrm()).isPresent()) {
            throw new RuntimeException("CRM ja cadastrado");
        }

        Medico medico = new Medico();
        medico.setNome(request.getNome());
        medico.setCrm(request.getCrm());
        medico.setEmail(request.getEmail());
        medico.setAtivo(true);
        medico.setCreatedAt(LocalDateTime.now());

        return repository.save(medico);
    }

    @Transactional
    public Medico inativar(Long id) {
        Medico medico = buscarPorId(id);
        medico.setAtivo(false);
        return repository.save(medico);
    }
}
