package com.strey.qnow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strey.qnow.model.Atendimento;
import com.strey.qnow.model.Loja;
import com.strey.qnow.model.Vendedor;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	
	
	List<Atendimento> findByLoja(Loja loja);
	
	List<Atendimento> findByVendedor(Vendedor vendedor);
	
	

}
