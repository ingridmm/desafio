package com.cadCompany.desafio.empresa;

import com.cadCompany.desafio.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "empresa")
@Entity(name = "Empresa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String cnpj;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Empresa(DadosCadastraisEmpresa dadosCadastraisEmpresa){
        this.ativo = true;
        this.nomeFantasia = dadosCadastraisEmpresa.nomeFantasia();
        this.cnpj = dadosCadastraisEmpresa.cnpj();
        this.endereco = new Endereco(dadosCadastraisEmpresa.endereco());
    }

    public void atualizarDados(DadosAtualizacaoEmpresa dados) {
        if (dados.nomeFantasia() != null) this.nomeFantasia = dados.nomeFantasia();
        if (dados.cnpj()!= null) this.cnpj = dados.cnpj();
        if (dados.endereco() != null) this.endereco.atualizarEndereco(dados.endereco());
    }

    public void inativar() {
        this.ativo = false;
    }
}
