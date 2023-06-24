package com.cadCompany.desafio.fornecedor;

import com.cadCompany.desafio.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastraisFornecedor(
        @NotBlank
        String nome,
        @NotBlank
        String cnpjOuCpf,
        String rg,
        String dataNascimento,
        @NotBlank @Email
        String email,
        @NotNull @Valid
        DadosEndereco endereco) {

        //DTO DA CLASSE CADASTRAL DE FORNECEDOR
        //é aqui que os campos estão chegando na requisição
        //Funciona com anotações


}
