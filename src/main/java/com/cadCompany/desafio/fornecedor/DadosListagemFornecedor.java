package com.cadCompany.desafio.fornecedor;

public record DadosListagemFornecedor(String nome, String cnpjOuCpf) {
    /*DTO Listagem Fornecedor*/
    public DadosListagemFornecedor(Fornecedor fornecedor){
        this(fornecedor.getNome(), fornecedor.getCnpjOuCpf());
    }
}
