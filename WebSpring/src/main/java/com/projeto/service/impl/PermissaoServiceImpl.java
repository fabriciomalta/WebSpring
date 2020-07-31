package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Permissao;
import com.projeto.repository.PermissaoRepository;
import com.projeto.service.PermissaoService;


@Service
@Transactional
public class PermissaoServiceImpl implements PermissaoService {
	
	@Autowired
	private PermissaoRepository permissaoRepository;

	@Override
	public List<Permissao> findAll() {
		return permissaoRepository.findAll();
	}

	@Override
	public Permissao save(Permissao entity) {
		return permissaoRepository.save(entity);
	}

	@Override
	public Permissao update(Permissao entity) {
		return this.save(entity);
	}

	@Override
	public Permissao getOne(Long id) {
		return permissaoRepository.getOne(id);
	}

	@Override
	public Permissao findById(Long id) {
		return permissaoRepository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		permissaoRepository.deleteById(id);
	}
		
	

}
