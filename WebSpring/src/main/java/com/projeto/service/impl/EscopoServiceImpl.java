package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Escopo;
import com.projeto.repository.EscopoRepository;
import com.projeto.service.EscopoService;

@Service
@Transactional
public class EscopoServiceImpl implements EscopoService {

	@Autowired
	private EscopoRepository escopoRepository;
	
	@Override
	public List<Escopo> findAll() {
		return escopoRepository.findAll();
	}

	@Override
	public Escopo save(Escopo entity) {
		return escopoRepository.save(entity);
	}

	@Override
	public Escopo update(Escopo entity) {
		return this.save(entity);
	}

	@Override
	public Escopo getOne(Long id) {
		return escopoRepository.getOne(id);
	}

	@Override
	public Escopo findById(Long id) {
		return escopoRepository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
       escopoRepository.deleteById(id);
	}

}
