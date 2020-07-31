package com.projeto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Planta;
import com.projeto.model.Usuario;
import com.projeto.service.PlantaService;
import com.projeto.service.RoleService;

@Controller
@RequestMapping(value="/planta")
public class PlantaController {

	@Autowired
	private PlantaService plantaservice;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView listarUsuarios(){
		ModelAndView mv = new ModelAndView("/planta/lista");
		List<Planta> listaPlanta = plantaservice.findAll();
		mv.addObject("listaPlanta", listaPlanta);
		return mv;
	}
	
}
