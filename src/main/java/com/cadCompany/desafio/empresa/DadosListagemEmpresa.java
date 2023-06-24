package com.cadCompany.desafio.empresa;

public record DadosListagemEmpresa(String nomeFantasia, String cnpj) {
    /*DTO Listagem Empresa*/
    public DadosListagemEmpresa(Empresa empresa){
        this(empresa.getNomeFantasia(), empresa.getCnpj());
    }

}
