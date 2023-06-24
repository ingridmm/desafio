package com.cadCompany.desafio.fornecedor;

import com.cadCompany.desafio.endereco.Endereco;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter

public class Fornecedor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpjOuCpf;
    private String nome;
    private String email;
    private String rg;
    private String dataNascimento;

    @Embedded
    private Endereco endereco;

    public Fornecedor(DadosCadastraisFornecedor dadosCadastraisFornecedor){
        this.nome = dadosCadastraisFornecedor.nome();
        this.cnpjOuCpf = dadosCadastraisFornecedor.cnpjOuCpf();
        this.email = dadosCadastraisFornecedor.email();
        this.rg = dadosCadastraisFornecedor.rg();
        this.dataNascimento = dadosCadastraisFornecedor.dataNascimento();
        this.endereco = new Endereco(dadosCadastraisFornecedor.endereco());
    }
}
