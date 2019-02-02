package com.bibliotecajpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecajpa.dto.LivroDTO;
import com.bibliotecajpa.dto.OrdemCompraDTO;
import com.bibliotecajpa.service.LivroService;
import com.bibliotecajpa.service.OrdemCompraService;

@RestController()
@RequestMapping(value="/livro")
public class LivroAPI {

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private OrdemCompraService ordemCompraService;
	
	@GetMapping
	private ResponseEntity<?> buscarTodosLivros() {
		System.out.println("buscou livro");
		return ResponseEntity.ok(livroService.buscarTodosLivros());
	}
	
	@GetMapping(value="/{nome}")
	private ResponseEntity<?> buscarLivroNome(@PathVariable String nome) {
		System.out.println("entrou na busca por nome");
		return ResponseEntity.ok(livroService.buscarLivrosNome(nome));
	}
	
	@PostMapping(value="/ordem")
	private ResponseEntity<?> ordemDeCompra(@RequestBody OrdemCompraDTO ordem) {
		System.out.println("entrou em ordem");
		return ResponseEntity.ok(ordemCompraService.validarOrdemCompra(ordem));
	}
	
	@PostMapping
	private ResponseEntity<?> insereLivro(@RequestBody LivroDTO livroDTO) {
		return ResponseEntity.ok(livroService.insereLivro(livroDTO));
	}
	
}
