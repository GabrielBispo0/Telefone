package br.com.teste.Telefone.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.Telefone.model.Planos;


public interface PlanosRepository extends JpaRepository<Planos, Long> {
	
	
}
