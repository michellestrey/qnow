package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strey.qnow.model.Vendedor;
import com.strey.qnow.repository.VendedorRepository;

import jakarta.transaction.Transactional;


@Service
public class VendedorService {
	
	private final VendedorRepository vendedorRepository;
	
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;		
	}

	
	@Transactional
	public Vendedor cadastrar(Vendedor vendedor) {
		   vendedorRepository.findByEmail(vendedor.getEmail())
				  .ifPresent(v -> {
				   throw new RuntimeException ("Email já está cadastrado, tente outro email");
				   });
		     
		return vendedorRepository.save(vendedor);
	}
	
	
	public List<Vendedor> listarTodos(){
		return vendedorRepository.findAll();
	}
	
	
	public Optional<Vendedor> buscaPorId(Long id){
		return vendedorRepository.findById(id);
		
	}
	
	
	@Transactional
	public Vendedor atualizar(Long id,Vendedor atualiza) {
		Vendedor vendedor = vendedorRepository.findById(id)
				       .orElseThrow(()
				       -> new RuntimeException("Id não encontrado: " + id));
		vendedor.setNome(atualiza.getNome());
		vendedor.setEmail(atualiza.getEmail());
			
		return vendedorRepository.save(vendedor);
	}
	
	
	@Transactional
	public void deletarPorId(Long id) {
		vendedorRepository.deleteById(id);
	}
		
	
	
}
