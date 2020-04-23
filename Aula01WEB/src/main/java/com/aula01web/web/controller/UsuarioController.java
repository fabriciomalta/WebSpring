package com.aula01web.web.controller;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aula01web.model.Role;
import com.aula01web.model.Usuario;
import com.aula01web.service.*;
import com.aula01web.service.exceptions.EmailCadastradoException;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView listarUsuarios(Usuario usuario){
			ModelAndView mv= new ModelAndView("usuario/lista");
			
			List<Usuario> listaUsuario = usuarioService.findAll();
			mv.addObject("listaUsuario", listaUsuario);
			return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView incluirUsuario(Usuario usuario) {
		ModelAndView mv= new ModelAndView("usuario/usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(value="/incluir", method = RequestMethod.POST)
	public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return incluirUsuario(usuario);
		}
		try {
			usuarioService.save(usuario);
		} catch(EmailCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return incluirUsuario(usuario);
		}
		
		
		//System.out.println(usuario.toString());
		return new ModelAndView("redirect:/usuario/list");
	}

	@RequestMapping(value="/editar", method = RequestMethod.POST)
	public ModelAndView updateUsuario(@Valid Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return incluirUsuario(usuario);
		}
		try {
			usuarioService.update(usuario);
		} catch(EmailCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return incluirUsuario(usuario);
		}
		

		return new ModelAndView("redirect:/usuario/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarUsuario(@PathVariable Long id) 
		{
		
		 ModelAndView mv = new ModelAndView("usuario/usuario");
		 Usuario usuario = usuarioService.getOne(id);
		 mv.addObject("usuario", usuario);
		 return mv;
		}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView buscarUsuarioExcluir(@PathVariable Long id) 
		{
		 ModelAndView mv = new ModelAndView("usuario/excluir_usuario");
		 Usuario usuario = usuarioService.getOne(id);
		 mv.addObject("usuario", usuario);
		 return mv;
		}

	@RequestMapping(value="/excluir", method = RequestMethod.POST)
	public ModelAndView excluirUsuario(Usuario user) {
		usuarioService.deleteById(user.getId());
		//System.out.println(usuario.toString());
		return new ModelAndView("redirect:/usuario/list");
	}
	
	
	@ModelAttribute("roles")
	public List<Role> listaRoles(){		
		return roleService.findAll();
	}

}

