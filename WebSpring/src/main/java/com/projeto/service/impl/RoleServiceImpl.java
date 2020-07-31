package com.projeto.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.config.ConfigProjeto;
import com.projeto.model.Role;
import com.projeto.model.UsuarioRoleAuditoria;
import com.projeto.repository.RoleRepository;
import com.projeto.repository.UsuarioRoleAuditoriaRepository;
import com.projeto.service.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
    @Autowired
	private RoleRepository roleRepository;
    
    @Autowired
    private UsuarioRoleAuditoriaRepository usuarioRoleAuditoriaRepository;
    
    @Override
    @Transactional(readOnly = true)
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role entity) {
		Role role = roleRepository.save(entity);
		saveUsuarioRoleAuditoria(role, ConfigProjeto.INCLUSAO);
		return role;
	}

	@Override
	public Role update(Role entity) { 
		Role role = roleRepository.save(entity);
		saveUsuarioRoleAuditoria(role, ConfigProjeto.ALTERACAO);
		return role;
	}

	@Override
	public Role getOne(Long id) {
		return roleRepository.getOne(id);
	}

	@Override
	public Role findRole(String role) {
		return null;
	}

	@Override
	public Role findById(Long id) {
		return roleRepository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		 saveUsuarioRoleAuditoria(getOne(id), ConfigProjeto.EXCLUSAO); 
		 roleRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true )
	public List<Role> findAllRoles() {
		return roleRepository.findAllRoles();
	}

	@Override
	@Transactional
	public void saveUsuarioRoleAuditoria(Role role, String operacao) {
		UsuarioRoleAuditoria ura = new UsuarioRoleAuditoria();
		ura.getAuditoria().setDataOperacao(new Date());
		ura.getAuditoria().setUsuario(ConfigProjeto.pegarUsuario());
		ura.getAuditoria().setTipoOperacao(operacao);
		ura.setRole(role);
        usuarioRoleAuditoriaRepository.save(ura); 		
	}

	
	
	
}
