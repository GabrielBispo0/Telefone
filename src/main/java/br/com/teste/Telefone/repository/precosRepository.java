package br.com.teste.Telefone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.Telefone.model.Precos;

public interface precosRepository extends JpaRepository<Precos, Long> {
	
	public List<Precos> findAllByOrigemAndDestino(Long origem, Long destino);
	public Precos findByOrigemAndDestino(Long origem, Long destino);
}
