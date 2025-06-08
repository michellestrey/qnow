package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strey.qnow.model.Gerente;
import com.strey.qnow.repository.GerenteRepository;

import jakarta.transaction.Transactional;


@Service
public class GerenteService {
	
	private final GerenteRepository gerenteRepository;

	public GerenteService(GerenteRepository gerenteRepository) {
		this.gerenteRepository = gerenteRepository;
	}
	
	
	@Transactional 
	public Gerente cadastrar(Gerente gerente) {
		  gerenteRepository.findByEmail(gerente.getEmail())
		  				   .ifPresent(g -> {
		  					throw new RuntimeException("Email já cadastrado, Tente outro email");
		  				   });
		   return gerenteRepository.save(gerente);
		  
	}
	
	public List<Gerente> listarTodos(){
		return gerenteRepository.findAll();
		 
		
	}
	
	public Optional<Gerente> buscaId(Long id){
		return gerenteRepository.findById(id);
		
	}
	
	@Transactional
	public Gerente atualizarGerente(Long id, Gerente dadosNovos) {
		  Gerente gerente= 	gerenteRepository.findById(id)
					.orElseThrow(()
					-> new RuntimeException("Id " + id + " não encontrado!" ));
		    gerente.setNome(dadosNovos.getNome());
		    gerente.setEmail(dadosNovos.getEmail());
		    return gerenteRepository.save(gerente);	
	}
	
	@Transactional
	public String deletarPorId(Long id) {
		if(!gerenteRepository.existsById(id)) {
			return "Gerente com o ID" + id + " não encontrado!";
		}
		
		gerenteRepository.deleteById(id);
		return "Gerente deletetado pelo ID:" + id;
		
	}
	
	
	
	
	
	

}
