package com.cadCompany.desafio.empresa;

import com.cadCompany.desafio.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEmpresa(
        @NotNull
        Long id,
        String nomeFantasia,
        String cnpj,
        DadosEndereco endereco) {

}
