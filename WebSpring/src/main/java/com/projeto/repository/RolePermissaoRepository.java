package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.RolePermissao;
import com.projeto.model.RolePermissaoId;
import com.projeto.repository.query.RolePermissaoQuery;

@Repository
public interface RolePermissaoRepository extends JpaRepository<RolePermissao, RolePermissaoId>, RolePermissaoQuery{

}
