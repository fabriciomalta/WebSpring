package com.projeto.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Role;
import com.projeto.model.Usuario;
import com.projeto.service.RoleService;
import com.projeto.service.UsuarioService;
import com.projeto.service.exceptions.ConfirmeSenhaNaoInformadaException;
import com.projeto.service.exceptions.EmailCadastradoException;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private RoleService roleService;
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView listarUsuarios(){
		ModelAndView mv = new ModelAndView("/usuario/lista");
		List<Usuario> listaUsuario = usuarioService.findAll();
		mv.addObject("listaUsuario", listaUsuario);
		return mv;
	}
	
	///CHAMA A PÁGINA DO NOVO CADASTRO
	@GetMapping("/novo")
	public ModelAndView cadastroUsuario(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView buscarUsuarioAlterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("usuario/usuario");
		Usuario usuario = usuarioService.getOne(id);
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView buscarUsuarioExcluir(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("usuario/excluir_usuario");
		Usuario usuario = usuarioService.getOne(id);
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	//REALIZA A VALIDAÇÃO E A INSERÇÃO DENTRO DA PÁGINA JÁ CHAMADA
	@RequestMapping(value= "/incluir",method = RequestMethod.POST)
	public ModelAndView incluirUsuario(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastroUsuario(usuario);
		}
		try {
			usuarioService.save(usuario);	
		} catch(EmailCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return cadastroUsuario(usuario);
		} catch( ConfirmeSenhaNaoInformadaException e) {
			result.rejectValue("confirmeSenha", e.getMessage(), e.getMessage());
			return cadastroUsuario(usuario);
		}
		return new ModelAndView("redirect:/usuario/list");
	}
	
	@RequestMapping(value= "/alterar",method = RequestMethod.POST)
	public ModelAndView alterarUsuario(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastroUsuario(usuario);
		}
		try {
			usuarioService.update(usuario);	
		} catch(EmailCadastradoException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return cadastroUsuario(usuario);
		}
		return new ModelAndView("redirect:/usuario/list");
	}
		
	@RequestMapping(value= "/excluir",method = RequestMethod.POST)
	public ModelAndView excluirUsuario(Usuario usuario) {
		usuarioService.deleteById(usuario.getId());
		return new ModelAndView("redirect:/usuario/list");
	}
	
	@ModelAttribute("roles")
	public List<Role> listaRoles(){
		return roleService.findAll();
	}
	
	
		
	
}







