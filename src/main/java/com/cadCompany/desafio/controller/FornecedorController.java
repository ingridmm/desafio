package com.cadCompany.desafio.controller;

import com.cadCompany.desafio.fornecedor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastraisFornecedor dados){

        String cnpjOuCpf = dados.cnpjOuCpf();
        String cnpjOuCpfValidado = validarCnpjCpf(cnpjOuCpf);

        if (cnpjOuCpfValidado.equals(cnpjOuCpf)) {

            if (isCpf(cnpjOuCpf)) {

                if (dados.dataNascimento() == null || dados.rg() == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("É necessário informar a data de nascimento e RG para CPF.");
                }
                fornecedorRepository.save(new Fornecedor(dados));
            } else {

                fornecedorRepository.save(new Fornecedor(dados));
            }
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ ou CPF inválido");
        }
        return null;
    }

    public String validarCnpjCpf(String cnpjOuCpf){
        if (cnpjOuCpf.length() == 11) { // CPF
            var cpf = cnpjOuCpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            return cpf;
        } else if (cnpjOuCpf.length() == 14) { // CNPJ
            var cnpj = cnpjOuCpf.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
            return cnpj;
        }
        return cnpjOuCpf;
    }

    private boolean isCpf(String cnpjOuCpf) {
        return cnpjOuCpf.length() == 11;
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
