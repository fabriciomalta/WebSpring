package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Plantio;
import com.projeto.repository.PlantioRepository;
import com.projeto.service.PlantioService;

@Service
@Transactional
public class PlantioServiceImpl implements PlantioService {

	@Autowired
	PlantioRepository plantiorepository;
	
	@Override
	public List<Plantio> findAll() {
		// TODO Auto-generated method stub
		return plantiorepository.findAll();
	}

	@Override
	public Plantio save(Plantio entity) {
		// TODO Auto-generated method stub
		return plantiorepository.save(entity);
	}

	@Override
	public Plantio update(Plantio entity) {
		// TODO Auto-generated method stub
		return plantiorepository.save(entity);
	}

	@Override
	public Plantio getOne(Long id) {
		// TODO Auto-generated method stub
		return plantiorepository.getOne(id);
	}

	@Override
	public Plantio findById(Long id) {
		// TODO Auto-generated method stub
		return plantiorepository.findById(id).orElseThrow(()-> new RuntimeException("Opa Plantio não cadastrado!"));
	}

	@Override
	public void deleteById(Long id) {
		plantiorepository.deleteById(id);
		
	}

}
