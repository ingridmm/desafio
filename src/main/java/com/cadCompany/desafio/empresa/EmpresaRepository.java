package com.cadCompany.desafio.empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Page<Empresa> findAllByAtivoTrue(Pageable paginacao);
}
