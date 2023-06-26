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
@CrossOrigin(origins = "*")
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
        //return empresaRepository.findAll(paginacao).stream().map(DadosListagemEmpresa::new).toList();
        //Tras as empresas ativas apenas
        return empresaRepository.findAllByAtivoTrue(paginacao).stream().map(DadosListagemEmpresa::new).toList();
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

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void excluir(@PathVariable long id){
        empresaRepository.deleteById(id);
    }

    @DeleteMapping(path = "/inativar/{id}")
    @Transactional
    public void inativar(@PathVariable long id){
        Empresa empresa = empresaRepository.getReferenceById(id);
        empresa.inativar();
    }

}
