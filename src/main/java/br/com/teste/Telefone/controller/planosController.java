package br.com.teste.Telefone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.teste.Telefone.model.Planos;
import br.com.teste.Telefone.repository.PlanosRepository;

@RestController
public class planosController {
	
	@Autowired
	private PlanosRepository planos;
	
	@GetMapping("/planos")
	public List<Planos> getPlanos() {
		return planos.findAll();
	}
}
