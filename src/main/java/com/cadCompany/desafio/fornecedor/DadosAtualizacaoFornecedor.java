package com.cadCompany.desafio.fornecedor;

import com.cadCompany.desafio.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFornecedor(
        @NotNull
        Long id,
        String nome,
        String cnpjOuCpf,
        String email,
        String rg,
        String dataNascimento,
        DadosEndereco endereco) {
}
