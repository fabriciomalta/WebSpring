package com.projeto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Colhido;
import com.projeto.repository.ColhidoRepository;
import com.projeto.service.ColhidoService;

@Service
@Transactional
public class ColhidoServiceImpl implements ColhidoService{

	
	ColhidoRepository colhidorepository;
	
	@Override
	public List<Colhido> findAll() {
		// TODO Auto-generated method stub
		return colhidorepository.findAll();
	}

	@Override
	public Colhido save(Colhido entity) {
		// TODO Auto-generated method stub
		return colhidorepository.save(entity);
	}

	@Override
	public Colhido update(Colhido entity) {
		// TODO Auto-generated method stub
		return colhidorepository.save(entity);
	}

	@Override
	public Colhido getOne(Long id) {
		// TODO Auto-generated method stub
		return colhidorepository.getOne(id);
	}

	@Override
	public Colhido findById(Long id) {
		// TODO Auto-generated method stub
		return colhidorepository.findById(id).orElseThrow(()-> new RuntimeException("Opa Colheita não cadastrada!"));
	}

	@Override
	public void deleteById(Long id) {
		 colhidorepository.deleteById(id);		
	}

}
