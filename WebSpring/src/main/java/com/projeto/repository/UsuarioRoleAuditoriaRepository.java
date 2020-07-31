package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.UsuarioRoleAuditoria;

@Repository
public interface UsuarioRoleAuditoriaRepository extends JpaRepository<UsuarioRoleAuditoria, Long> {

}
