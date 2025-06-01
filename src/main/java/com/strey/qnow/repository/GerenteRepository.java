package com.strey.qnow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strey.qnow.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
	
	
	Optional<Gerente> findByEmail(String email);

}
