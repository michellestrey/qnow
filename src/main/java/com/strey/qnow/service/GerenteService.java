package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.strey.qnow.dto.gerentdto.CreateGerenteDTO;
import com.strey.qnow.dto.gerentdto.GerenteResponseDTO;
import com.strey.qnow.dto.gerentdto.UpdateGerenteDTO;
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
	public Gerente cadastrar(CreateGerenteDTO dto) {
		gerenteRepository.findByEmail(dto.getEmail())
		.ifPresent(g -> {
			throw new RuntimeException("Email já cadastrado, Tente outro email");
		});
		//CONVERTE 
		Gerente gerente = new Gerente();
		gerente.setNome(dto.getNome());
		gerente.setEmail(dto.getEmail());
		gerente.setSenha(dto.getSenha());


		return gerenteRepository.save(gerente);

	}

	public List<GerenteResponseDTO> listarTodos(){
		List<Gerente> gerentes = gerenteRepository.findAll();
		return gerentes.stream()
				.map(GerenteResponseDTO::new)
				.collect(Collectors.toList());


	}

	public GerenteResponseDTO buscaId(Long id){
		Gerente gerente = gerenteRepository.findById(id)
				.orElseThrow(() ->new RuntimeException("Id não encontrado"));
		return new GerenteResponseDTO(gerente);

	}

	@Transactional
	public Gerente atualizarGerente(Long id, UpdateGerenteDTO dto) {
		Gerente gerente= 	gerenteRepository.findById(id)
				.orElseThrow(()
						-> new RuntimeException("Id " + id + " não encontrado!" ));
		Optional.ofNullable(dto.getNome()).ifPresent(gerente::setNome);
		Optional.ofNullable(dto.getEmail()).ifPresent(gerente::setEmail);
		Optional.ofNullable(dto.getSenha()).ifPresent(gerente::setSenha);

		return gerenteRepository.save(gerente);	
	}

	@Transactional
	public String deletarPorId(Long id) {
		if(!gerenteRepository.existsById(id)) {
			return "Gerente com o ID" + id + " não encontrado!";
		}

		gerenteRepository.deleteById(id);
		return "Gerente deletado pelo ID:" + id;

	}


}
