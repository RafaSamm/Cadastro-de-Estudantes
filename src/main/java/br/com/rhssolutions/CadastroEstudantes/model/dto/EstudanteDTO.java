package br.com.rhssolutions.CadastroEstudantes.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstudanteDTO(@NotBlank(message = "O nome deve ser informado")
                           @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
                           String nome,
                           @NotBlank(message = "O email deve ser informado")
                           @Size(min = 2, message = "O email deve ter no mínimo 2 caracteres")
                           String email,
                           @Min(value = 18, message = "A idade deve ser maior ou igual a 18")
                           Integer idade) {


}

