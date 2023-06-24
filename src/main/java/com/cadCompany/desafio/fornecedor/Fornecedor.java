package com.cadCompany.desafio.fornecedor;

import com.cadCompany.desafio.empresa.Empresa;
import com.cadCompany.desafio.endereco.Endereco;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

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

    @ManyToOne
    private Empresa empresa;

    public Fornecedor(DadosCadastraisFornecedor dadosCadastraisFornecedor){
        this.nome = dadosCadastraisFornecedor.nome();
        this.cnpjOuCpf = dadosCadastraisFornecedor.cnpjOuCpf();
        this.email = dadosCadastraisFornecedor.email();
        this.rg = dadosCadastraisFornecedor.rg();
        this.dataNascimento = dadosCadastraisFornecedor.dataNascimento();
        this.endereco = new Endereco(dadosCadastraisFornecedor.endereco());
    }

    public void atualizarFornecedor(DadosAtualizacaoFornecedor dados) {
        if(dados.nome()!=null) this.nome = dados.nome();
        if(dados.cnpjOuCpf()!=null) this.cnpjOuCpf = dados.cnpjOuCpf();
        if(dados.email()!=null) this.email = dados.email();
        if(dados.rg()!=null) this.rg = dados.rg();
        if(dados.dataNascimento()!=null) this.dataNascimento = dados.dataNascimento();
        if(dados.endereco()!=null) this.endereco.atualizarEndereco(dados.endereco());
    }
}
