package br.com.teste.Telefone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.teste.Telefone.model.Precos;
import br.com.teste.Telefone.repository.precosRepository;

@Controller
public class precosController {
	
	@Autowired
	private  precosRepository precosRepository;
	
	@PostMapping("/produtos")
	private ModelAndView listaPromocao() {
		ModelAndView mv = new ModelAndView("produtos/formProduto");
		List<Precos> Precos = precosRepository.findAll();
		mv.addObject(Precos);
		return mv;
	}

}
