package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Planta;
import com.projeto.repository.PlantaRepository;
import com.projeto.service.PlantaService;

@Service
@Transactional
public class PlantaServiceImpl implements PlantaService {

	@Autowired
	PlantaRepository plantarepository;
	
	@Override
	public List<Planta> findAll() {
		// TODO Auto-generated method stub
		return plantarepository.findAll();
	}

	@Override
	public Planta save(Planta entity) {
		// TODO Auto-generated method stub
		return plantarepository.save(entity);
	}

	@Override
	public Planta update(Planta entity) {
		// TODO Auto-generated method stub
		return plantarepository.save(entity);
	}

	@Override
	public Planta getOne(Long id) {
		// TODO Auto-generated method stub
		return plantarepository.getOne(id);
	}

	@Override
	public Planta findById(Long id) {
		// TODO Auto-generated method stub
		return plantarepository.findById(id).orElseThrow(()-> new RuntimeException("Opa Planta não cadastrada!"));
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		plantarepository.deleteById(id);
		
	}

}
