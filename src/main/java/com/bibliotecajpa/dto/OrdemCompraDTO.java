package com.bibliotecajpa.dto;


public class OrdemCompraDTO {


	private String nome;
	private int quantidade;
	private double total;
		
	public OrdemCompraDTO() {
		
	}
	
	public OrdemCompraDTO(String nome, int quantidade) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
	
	}
	
	
	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
