package com.clinicaapp.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PacienteRequest {

    @NotBlank(message = "Nome e obrigatorio")
    @Size(max = 100, message = "Nome deve ter no maximo 100 caracteres")
    private String nome;

    @NotBlank(message = "CPF e obrigatorio")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 digitos")
    private String cpf;

    @NotNull(message = "Data de nascimento e obrigatoria")
    private LocalDate dataNascimento;

    @Size(max = 20)
    private String telefone;

    @Email(message = "Email invalido")
    private String email;
}
