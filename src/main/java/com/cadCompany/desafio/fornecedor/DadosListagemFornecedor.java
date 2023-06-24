package com.cadCompany.desafio.fornecedor;

public record DadosListagemFornecedor(Long id, String nome, String cnpjOuCpf) {
    /*DTO Listagem Fornecedor*/
    public DadosListagemFornecedor(Fornecedor fornecedor){
        this(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpjOuCpf());
    }
}
