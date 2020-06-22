package com.aula01web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aula01web.model.Escopo;
import com.aula01web.repository.EscopoRepository;
import com.aula01web.repository.RoleRepository;
import com.aula01web.service.EscopoService;

@Service
@Transactional
public class EscopoServiceImpl implements EscopoService{

    //@Autowired
	//private EscopoRepository escopoRepository;
    
	@Override
	public List<Escopo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Escopo save(Escopo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Escopo update(Escopo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Escopo getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Escopo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
