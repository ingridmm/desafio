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

    @Embedded
    private Endereco endereco;

    public Empresa(DadosCadastraisEmpresa dadosCadastraisEmpresa){
        this.nomeFantasia = dadosCadastraisEmpresa.nomeFantasia();
        this.cnpj = dadosCadastraisEmpresa.cnpj();
        this.endereco = new Endereco(dadosCadastraisEmpresa.endereco());
    }
}
