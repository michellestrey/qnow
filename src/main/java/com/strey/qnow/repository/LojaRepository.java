package com.strey.qnow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strey.qnow.model.Loja;

public interface LojaRepository extends JpaRepository <Loja, Long> {
	
	Optional<Loja> findByCnpj(String cnpj);
	Optional<Loja> findByEmail(String email);
	boolean existsByEmail(String email);


}
