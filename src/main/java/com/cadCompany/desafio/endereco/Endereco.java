package com.cadCompany.desafio.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String complemento;
    private String numero;
    private String cidade;
    private String uf;


    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarEndereco(DadosEndereco dadosEndereco) {
        if(dadosEndereco.logradouro() != null) this.logradouro = dadosEndereco.logradouro();
        if(dadosEndereco.bairro() != null) this.bairro = dadosEndereco.bairro();
        if(dadosEndereco.cep() != null) this.cep = dadosEndereco.cep();
        if(dadosEndereco.complemento() != null) this.complemento = dadosEndereco.complemento();
        if(dadosEndereco.numero() != null) this.numero = dadosEndereco.numero();
        if(dadosEndereco.cidade() != null) this.cidade = dadosEndereco.cidade();
        if(dadosEndereco.uf() != null) this.uf = dadosEndereco.uf();
    }
}
