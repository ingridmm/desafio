package com.cadCompany.desafio.empresa;

public record DadosListagemEmpresa(Long id, String nomeFantasia, String cnpj) {
    /*DTO Listagem Empresa*/
    public DadosListagemEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getNomeFantasia(), empresa.getCnpj());
    }

}
