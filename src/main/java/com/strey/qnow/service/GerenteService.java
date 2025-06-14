package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strey.qnow.dto.gerentedto.CreateGerenteDTO;
import com.strey.qnow.dto.gerentedto.MensagemResponseDTO;
import com.strey.qnow.dto.gerentedto.ResponseGerenteDTO;
import com.strey.qnow.dto.gerentedto.UpdateGerenteDTO;
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
	public ResponseGerenteDTO cadastrar(CreateGerenteDTO dto) {
		boolean existe = gerenteRepository.findByEmail(dto.email()).isPresent();
		if(existe) {
			throw new RuntimeException("Email já cadastrado! \n Tente outro email.");
		}
		//CONVERTE 
		Gerente gerente = new Gerente();
		gerente.setNome(dto.nome());
		gerente.setEmail(dto.email());
		gerente.setSenha(dto.senha());
		
		Gerente salvo = gerenteRepository.save(gerente);
		
		return new ResponseGerenteDTO(salvo.getId(), salvo.getNome(), salvo.getEmail());
	}

	public List<ResponseGerenteDTO> listarTodos(){
		
		return gerenteRepository.findAll()
				.stream()
				.map(g -> new ResponseGerenteDTO(g.getId(), g.getNome(), g.getEmail()))
				.toList();


	}

	public ResponseGerenteDTO buscaId(Long id){
		   return gerenteRepository.findById(id)
				   .map(g -> new ResponseGerenteDTO(g.getId(), g.getNome(), g.getEmail()))
				   .orElseThrow( () -> new RuntimeException("Id não encontrado"));
	}

	@Transactional    //TRABALHAR VALIDAÇÕES!
	public ResponseGerenteDTO atualizarGerente(Long id, UpdateGerenteDTO dto) {
		Gerente gerente= 	gerenteRepository.findById(id)
				.orElseThrow(()
						-> new RuntimeException("Id " + id + " não encontrado!" ));
		Optional.ofNullable(dto.getNome()).ifPresent(gerente::setNome);
		
		Optional.ofNullable(dto.getEmail()).ifPresent(gerente::setEmail);
		
		Optional.ofNullable(dto.getSenha()).ifPresent(gerente::setSenha);

		 Gerente gerenteAtualizado = gerenteRepository.save(gerente);	
		 
		 return new ResponseGerenteDTO(
				 gerenteAtualizado.getId(),
				 gerenteAtualizado.getNome(),
				 gerenteAtualizado.getEmail()
				 );
	}

	@Transactional
	public MensagemResponseDTO deletarPorId(Long id) {
		if(!gerenteRepository.existsById(id)) {
			return new MensagemResponseDTO("Gerente com o ID " + id + " não encontrado!");
		}

		gerenteRepository.deleteById(id);
		return new MensagemResponseDTO("Gerente deletado pelo ID: " + id);

	}


}
