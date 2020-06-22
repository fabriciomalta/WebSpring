package com.aula01web.web.controller;

import java.io.Console;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aula01web.model.Escopo;
import com.aula01web.model.Permissao;
import com.aula01web.model.Role;
import com.aula01web.model.RolePermissao;
import com.aula01web.model.RolePermissaoId;
import com.aula01web.service.EscopoService;
import com.aula01web.service.PermissaoService;
import com.aula01web.service.RolePermissaoService;
import com.aula01web.service.RoleService;


@Controller
@RequestMapping(value="/direitos")
public class RolePermissaoController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissaoService permissaoService;
	


	@Autowired
	private EscopoService escopoService;
		
	@Autowired
	private RolePermissaoService rolePermissaoService;
	
	@RequestMapping(value="/list")
	public ModelAndView listarRolePermissoes() {
	      ModelAndView mv = new ModelAndView("/rolepermissao/lista");
	      List<RolePermissao> listaRolePermissao = rolePermissaoService.findAll();
	      mv.addObject("listaRolePermissao", listaRolePermissao);
	      return mv;
	}
	
	@RequestMapping(value="/novo")
	public ModelAndView novoCadastroRolePermissao(RolePermissao rolePermissao) {
		ModelAndView mv = new ModelAndView("/rolepermissao/rolepermissao");
		mv.addObject("rolePermissao", rolePermissao);
		return mv;
	}
	
	
	
	@RequestMapping(value="/incluir", method=RequestMethod.POST)
	public ModelAndView incluirRolePermissao(RolePermissao rolePermissao) {

		RolePermissaoId id = new RolePermissaoId();
		
		id.setRoleId(rolePermissao.getRole_id().getId());
		id.setPermissaoId(rolePermissao.getPermissao_id().getId());
		id.setEscopoId(rolePermissao.getEscopo_id().getId());
		
		rolePermissao.setId(id);
		
		rolePermissaoService.save(rolePermissao);
		return new ModelAndView("redirect:/direitos/list");
	}
	
	
	@RequestMapping(value="/excluir/{role_id}/{permissao_id}/{escopo_id}")
	public ModelAndView excluirCadastroRolePermissao(@PathVariable Long role_id,
													 @PathVariable Long permissao_id,
													 @PathVariable Long escopo_id) {
		
		RolePermissaoId id = new RolePermissaoId();
		
		id.setRoleId(role_id);
		id.setPermissaoId(permissao_id);
		id.setEscopoId(escopo_id);
		
		RolePermissao rolePermissao = rolePermissaoService.getOne(id);
		
		ModelAndView mv = new ModelAndView("/rolepermissao/excluirrolepermissao");
		
		mv.addObject("rolepermissao", rolePermissao);
		
		return mv;
		
	}
		
	@ModelAttribute("roles")
	public List<Role> listarRoles(){
		
		return roleService.findAll();
	}
	
	
	
	@ModelAttribute("permissoes")
	public List<Permissao> listarPermissoes(){

		return permissaoService.findAll();
	}
	
	@ModelAttribute("escopos")	
	public List<Escopo> listarEscopos(){
	//	List<Permissao> asd = permissaoService.findAll();
		//System.out.println(asd.get(0).getNome());
		return escopoService.findAll();
	}	
}