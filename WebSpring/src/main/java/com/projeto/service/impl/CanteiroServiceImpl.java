package com.projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Canteiro;
import com.projeto.repository.CanteiroRepository;
import com.projeto.service.CanteiroService;

@Service
@Transactional
public class CanteiroServiceImpl implements CanteiroService{

	@Autowired
	CanteiroRepository canteirorepository;
	
	@Override
	public List<Canteiro> findAll() {
		// TODO Auto-generated method stub
		return canteirorepository.findAll();
	}

	@Override
	public Canteiro save(Canteiro entity) {
		// TODO Auto-generated method stub
		return canteirorepository.save(entity);
	}

	@Override
	public Canteiro update(Canteiro entity) {
		// TODO Auto-generated method stub
		return canteirorepository.save(entity);
	}

	@Override
	public Canteiro getOne(Long id) {
		// TODO Auto-generated method stub
		return canteirorepository.getOne(id);
	}

	@Override
	public Canteiro findById(Long id) {
		// TODO Auto-generated method stub
		return canteirorepository.findById(id).orElseThrow(()-> new RuntimeException("Opa Colheita não cadastrada!"));
	}

	@Override
	public void deleteById(Long id) {
		 canteirorepository.deleteById(id);
		
	}

}
