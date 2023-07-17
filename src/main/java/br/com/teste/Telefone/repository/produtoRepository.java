package br.com.teste.Telefone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.Telefone.model.Produto;

public interface produtoRepository extends JpaRepository<Produto, Long> {

}
