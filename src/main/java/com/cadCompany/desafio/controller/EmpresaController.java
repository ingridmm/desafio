package com.cadCompany.desafio.controller;

import com.cadCompany.desafio.empresa.DadosCadastraisEmpresa;
import com.cadCompany.desafio.empresa.DadosListagemEmpresa;
import com.cadCompany.desafio.empresa.Empresa;
import com.cadCompany.desafio.empresa.EmpresaRepository;
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
}
