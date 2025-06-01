package com.strey.qnow.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.strey.qnow.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	
	List<Vendedor> findByNome(String nome);//BUSCA POR NOME
	
	
	List<Vendedor> findByNomeContainingIgnoreCase(String nomeParcial);//BUSCA POR NOME PARCIAL
	
	Vendedor findByEmail(String email);
	
	
}
