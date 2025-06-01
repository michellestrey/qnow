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
		Vendedor existe = vendedorRepository.findByEmail(vendedor.getEmail());
		if(existe != null) {
			throw new RuntimeException("Já existe um vendedor com ess e-mail");		
		}
		return vendedorRepository.save(vendedor);
	}
	
	public List<Vendedor> listarTodos(){
		
		return vendedorRepository.findAll();
	}
	
	public Optional<Vendedor> buscaPorId(Long id){
		return vendedorRepository.findById(id);
		
	}
	@Transactional
	public void deletarPorId(Long id) {
		vendedorRepository.deleteById(id);
	}
	
	
	
	
}
