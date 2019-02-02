package com.bibliotecajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecajpa.dto.OrdemCompraDTO;
import com.bibliotecajpa.model.Livro;

@Service
public class OrdemCompraService {
	
	@Autowired
	private LivroService livroService;

	public OrdemCompraDTO validarOrdemCompra(OrdemCompraDTO ordem) {
		System.out.println("entrou no metodo ");
		Livro livro =(Livro) livroService.buscarLivrosNome(ordem.getNome());
		if (livro==null) {
			throw new IllegalArgumentException("Livro inexistente");
		}
		if(ordem.getQuantidade()<=0) {
			throw new IllegalArgumentException("Quantidade tem de ser maior que zero");
		}
		ordem.setTotal(livro.getValor()*ordem.getQuantidade());
		return ordem;
		
	}
}
