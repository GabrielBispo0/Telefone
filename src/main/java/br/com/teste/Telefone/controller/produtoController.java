package br.com.teste.Telefone.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import br.com.teste.Telefone.model.Precos;
import br.com.teste.Telefone.model.Produto;
import br.com.teste.Telefone.repository.precosRepository;
import br.com.teste.Telefone.repository.produtoRepository;

@Controller
public class produtoController {

	@Autowired
	private produtoRepository produtoRepository;

	@Autowired
	private precosRepository precosRepository;

	@GetMapping("/cadastrarProduto")
	private String form() {
		return "produtos/formProduto";
	}

	@PostMapping("/cadastrarProduto")
	private String cadastrar(@RequestBody String texto, Produto produto, Precos precos) {
		produto.calcularPromocao(produto, precosRepository);
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}

	@GetMapping("/produtos")
	private ModelAndView listar() {
		ModelAndView mv = new ModelAndView("index");
		List<Produto> Produtos = produtoRepository.findAll();
		mv.addObject("produtos", Produtos);
		System.out.println();
		return mv;
	}

}
