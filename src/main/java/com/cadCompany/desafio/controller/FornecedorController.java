package com.cadCompany.desafio.controller;

import com.cadCompany.desafio.fornecedor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public List<DadosListagemFornecedor> list(Pageable paginacao){
        return fornecedorRepository.findAll(paginacao).stream().map(DadosListagemFornecedor::new).toList();
    }

    @GetMapping(path = {"/{id}"})
    public List<DadosListagemFornecedor> findByIdFornecedor(@PathVariable long id){
        return fornecedorRepository.findById(id).stream().map(DadosListagemFornecedor::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoFornecedor dados){
        Fornecedor fornecedor = fornecedorRepository.getReferenceById(dados.id());
        fornecedor.atualizarFornecedor(dados);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void excluir(@PathVariable long id){
        fornecedorRepository.deleteById(id);
    }

}
