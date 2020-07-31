package com.aula01web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aula01web.model.Usuario;
import com.aula01web.repository.UsuarioRepository;
import com.aula01web.service.UsuarioService;
import com.aula01web.service.exceptions.EmailCadastradoException;
import com.aula01web.service.exceptions.NegocioException;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(Usuario entity) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuarioCadastrado= this.findUsuarioByEmail(entity.getEmail());
		
		if (usuarioCadastrado.isPresent() && !usuarioCadastrado.get().equals(entity)) {
			throw new EmailCadastradoException(String.format("O Email %s já existente", entity.getEmail()));
		}
		return usuarioRepository.save(entity);
		
		
	}

	@Override
	public Usuario update(Usuario entity) {
		// TODO Auto-generated method stub
		return this.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario getOne(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}
	
	@Override
	public Usuario findById(Long id) 
	{
		return usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));
	}
	
	@Override
	public Optional<Usuario> findUsuarioByEmail(String email){
		return usuarioRepository.findUsuarioByEmail(email);
	}

}
