package com.clinicaapp.backend.service;

import com.clinicaapp.backend.dto.EspecialidadeRequest;
import com.clinicaapp.backend.model.Especialidade;
import com.clinicaapp.backend.repository.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    public List<Especialidade> listarTodas() {
        return repository.findAll();
    }

    public Especialidade buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade nao encontrada"));
    }

    public Especialidade cadastrar(EspecialidadeRequest request) {
        if (repository.findByNome(request.getNome()).isPresent()) {
            throw new RuntimeException("Especialidade ja cadastrada");
        }

        Especialidade especialidade = new Especialidade();
        especialidade.setNome(request.getNome());

        return repository.save(especialidade);
    }
}
