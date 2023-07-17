package br.com.teste.Telefone.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Precos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long origem;
	private Long destino;
	private BigDecimal preco;
	
	
	public Long getOrigem() {
		return origem;
	}
	public void setOrigem(Long origem) {
		this.origem = origem;
	}
	public Long getDestino() {
		return destino;
	}
	public void setDestino(Long destino) {
		this.destino = destino;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Precos [id=" + id + ", origem=" + origem + ", destino=" + destino + ", preco=" + preco + "]";
	}
	
	
}
