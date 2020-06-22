package com.aula01web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula01web.model.Escopo;
import com.aula01web.model.RolePermissao;
import com.aula01web.model.RolePermissaoId;

@Repository
public interface EscopoRepository extends JpaRepository<Escopo, Long> {

}
