package com.strey.qnow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strey.qnow.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	
	List<Vendedor> findByNome(String nome);//BUSCA POR NOME
	
	
	List<Vendedor> findByNomeContainingIgnoreCase(String nomeParcial);//BUSCA POR NOME PARCIAL
	
	Optional<Vendedor> findByEmail(String email);
	
	
}
