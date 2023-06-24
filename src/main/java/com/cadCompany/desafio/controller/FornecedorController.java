package com.cadCompany.desafio.controller;

import com.cadCompany.desafio.fornecedor.DadosCadastraisFornecedor;
import com.cadCompany.desafio.fornecedor.ForncedorRepository;
import com.cadCompany.desafio.fornecedor.Fornecedor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private ForncedorRepository fornecedorRepository;

    @PostMapping
    @Transactional //necessário ter uma anotação ativa no BD
    public void cadastrar(@RequestBody @Valid DadosCadastraisFornecedor dados){
        //leva a informação no corpo da requisição json, chama o repository pega os dados do DTO e converteu para entidade Forcenedor e salvou no BD

        fornecedorRepository.save(new Fornecedor(dados));
    }



}
