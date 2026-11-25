package br.com.cotiinformatica.api_agenda.application.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContatoRequest(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 6, max = 100, message = "O nome deve ter entre 6 e 100 caracteres")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email é inválido")
        String email
) {
}
