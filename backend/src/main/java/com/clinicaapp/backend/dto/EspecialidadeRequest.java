package com.clinicaapp.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EspecialidadeRequest {

    @NotBlank(message = "Nome e obrigatorio")
    @Size(max = 100, message = "Nome deve ter no maximo 100 caracteres")
    private String nome;
}
