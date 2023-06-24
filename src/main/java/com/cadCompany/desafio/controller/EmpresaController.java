package com.cadCompany.desafio.controller;

import com.cadCompany.desafio.empresa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping
    @Transactional
    public void cadastar(@RequestBody @Valid DadosCadastraisEmpresa dados){
        empresaRepository.save(new Empresa(dados));
    }

    @GetMapping
    public List<DadosListagemEmpresa> list(Pageable paginacao){
        return empresaRepository.findAll(paginacao).stream().map(DadosListagemEmpresa::new).toList();
    }

    @GetMapping(path = {"/{id}"})
    public List<DadosListagemEmpresa> findBydId(@PathVariable long id){
        return empresaRepository.findById(id).stream().map(DadosListagemEmpresa::new).toList();
    }

    @PutMapping
    @Transactional //faz uma escrita BD
    public void atualizar(@RequestBody @Valid DadosAtualizacaoEmpresa dados){
        Empresa empresa = empresaRepository.getReferenceById(dados.id());
        empresa.atualizarDados(dados);
    }

}
