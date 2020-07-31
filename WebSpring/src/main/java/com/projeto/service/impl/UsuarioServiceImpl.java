package com.projeto.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;
import com.projeto.service.UsuarioService;
import com.projeto.service.exceptions.ConfirmeSenhaNaoInformadaException;
import com.projeto.service.exceptions.EmailCadastradoException;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasPermission('USUARIO','LEITURA')")
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	@PreAuthorize("hasPermission('USUARIO','INSERIR')")
	public Usuario save(Usuario entity) {
		
		Optional<Usuario> usuarioCadastrado = 
				this.findUsuarioByEmail(entity.getEmail());
		
		if (usuarioCadastrado.isPresent() && !usuarioCadastrado.get().equals(entity)) {
			throw new EmailCadastradoException(
					String.format("O E-mail %s já está cadastrado no sistema ", entity.getEmail()));
		}
		
	    if (entity.getConfirmeSenha().equals("")) {
	    	throw new ConfirmeSenhaNaoInformadaException("A senha não pode estar em branco!");
	    }
	    
	    entity.setPassword(encodePassword(entity.getPassword()));

	    entity.setAtivo(Boolean.TRUE);
	    
	    entity.setDeleted(Boolean.FALSE);
	    
	    if ("".equals(entity.getFoto()) || entity.getFoto() == null ) {
	    	entity.setFoto("default-avatar.png");
	    	entity.setContentType("image/png");
	    }	
	   
		return usuarioRepository.save(entity);
	}

	
	@Override
	@PreAuthorize("hasPermission('USUARIO','ATUALIZAR')")
	public Usuario update(Usuario entity) {
		return this.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasPermission('USUARIO','LEITURA')")
	public Usuario getOne(Long id) {
		return usuarioRepository.getOne(id);
	}
	
	@Override
	@PreAuthorize("hasPermission('USUARIO','LEITURA')")
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id)
				  .orElseThrow(()-> new RuntimeException("Usuário não cadastrdo!"));
	}

	@Override
	@PreAuthorize("hasPermission('USUARIO','EXCLUIR')")
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
	@Override
	public Optional<Usuario> findUsuarioByEmail(String email){
		return usuarioRepository.findUsuarioByEmail(email);
	}

	
	@Override
	public Optional<Usuario> loginUsuarioByEmail(String email) {
		return usuarioRepository.loginUsuarioByEmail(email);
	}

	@Override
	public void updateLoginUsuario(Usuario usuario) {
		usuario.setLastLogin(new Date());
		usuario.setFailedLogin(0);
		usuarioRepository.save(usuario);
	}

	@Override
	public void blockedUsuario(Usuario usuario) {
		usuario.setAtivo(Boolean.FALSE);
		usuarioRepository.save(usuario);
	}

	@Override
	public void updateFailedAccess(Usuario usuario) {
		Integer totalAcesso = usuario.getFailedLogin() + 1;
		usuario.setFailedLogin(totalAcesso);
		usuarioRepository.save(usuario);
		
	}

	
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}



	
}
