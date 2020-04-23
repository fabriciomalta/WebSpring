package com.aula01web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aula01web.model.Role;
import com.aula01web.repository.RoleRepository;
import com.aula01web.service.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
    @Autowired
	private RoleRepository roleRepository;
    
    @Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role entity) {
		return roleRepository.save(entity);
	}

	@Override
	public Role update(Role entity) { 
		return roleRepository.save(entity);
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
	     roleRepository.deleteById(id);
		
	}
	
}