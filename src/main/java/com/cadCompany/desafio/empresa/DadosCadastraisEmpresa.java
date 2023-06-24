package com.cadCompany.desafio.empresa;

import com.cadCompany.desafio.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record DadosCadastraisEmpresa(
        @NotBlank
        String nomeFantasia,
        @NotBlank @CNPJ
        String cnpj,
        @NotNull @Valid
        DadosEndereco endereco) {
    //DTO DA CLASSE CADASTRAL DE EMPRESA
}
