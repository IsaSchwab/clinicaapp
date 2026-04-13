package com.clinicaapp.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MedicoRequest {

    @NotBlank(message = "Nome e obrigatorio")
    @Size(max = 100, message = "Nome deve ter no maximo 100 caracteres")
    private String nome;

    @NotBlank(message = "CRM e obrigatorio")
    @Size(max = 20, message = "CRM deve ter no maximo 20 caracteres")
    private String crm;

    @NotBlank(message = "Email e obrigatorio")
    @Email(message = "Email invalido")
    private String email;
}
