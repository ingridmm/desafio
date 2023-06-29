package com.cadCompany.desafio.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        String logradouro,
        String bairro,
        @NotBlank @Pattern(regexp = "\\d{5}-\\d{3}")
        String cep,
        String complemento,
        String numero,

        String cidade,

        String uf) {
}
