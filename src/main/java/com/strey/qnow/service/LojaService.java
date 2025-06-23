package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strey.qnow.dto.lojadto.CreateLojaDTO;
import com.strey.qnow.dto.lojadto.MensagemLojaDTO;
import com.strey.qnow.dto.lojadto.ResponseLojaDTO;
import com.strey.qnow.dto.lojadto.UpdateLojaDTO;
import com.strey.qnow.model.Loja;
import com.strey.qnow.repository.LojaRepository;

import jakarta.transaction.Transactional;

@Service
public class LojaService {

	private final LojaRepository lojaRepository;

	public LojaService(LojaRepository lojaRepository) {
		this.lojaRepository = lojaRepository;	
	}


	@Transactional
	public ResponseLojaDTO cadastrarLoja(CreateLojaDTO dto){
		
	
	    boolean existe = lojaRepository.existsByEmail(dto.email());
		if(existe) {
			throw new RuntimeException("Email já cadastrado. \n Tente outro email!");
		}
		Loja loja = new Loja();
		loja.setNome(dto.nome());
		loja.setEndereco(dto.endereco());
		loja.setCnpj(dto.cnpj());
		loja.setEmail(dto.email());
		loja.setSenha(dto.senha());
		
		Loja salva = lojaRepository.save(loja);
		return new ResponseLojaDTO(salva.getId(), salva.getNome(),salva.getEmail(),
								   salva.getCnpj());
	}

	public List<ResponseLojaDTO>listarLojas() {
		return lojaRepository.findAll()
			.stream()
			.map(l -> new ResponseLojaDTO(l.getId(), l.getNome(), l.getEmail(), l.getCnpj()))
			.toList();
					
					
					
	}  

	public ResponseLojaDTO buscarId(Long id){
		return lojaRepository.findById(id)
				      .map(l -> new ResponseLojaDTO(l.getId(), l.getNome(), l.getEmail(), l.getCnpj()))
				      .orElseThrow(() -> new RuntimeException("Id " + id+ " não encontrado") );

	}

	@Transactional
	public ResponseLojaDTO atualizarLoja(Long id, UpdateLojaDTO dto) {
			Loja loja = lojaRepository.findById(id)
			.orElseThrow(()
					-> new RuntimeException("Id não encontrado: " + id));
		
		
		Optional.ofNullable(dto.getNome()).ifPresent(loja::setNome);
		Optional.ofNullable(dto.getEndereco()).ifPresent(loja::setEndereco);
		Optional.ofNullable(dto.getCnpj()).ifPresent(loja::setCnpj);
		Optional.ofNullable(dto.getEmail()).ifPresent(loja::setEmail);
		Optional.ofNullable(dto.getSenha()).ifPresent(loja::setSenha);
		
		Loja lojaAtualizada = lojaRepository.save(loja);
		
		return new ResponseLojaDTO(
				lojaAtualizada.getId(),
				lojaAtualizada.getNome(),
				lojaAtualizada.getEmail(),
     			lojaAtualizada.getCnpj());
		}

	@Transactional
	public MensagemLojaDTO deletarLojaPorId(Long id) {
		if(!lojaRepository.existsById(id)) {
			return new MensagemLojaDTO("Loja com o ID " + id + " não encontrada");
		}
		lojaRepository.deleteById(id);
		return new MensagemLojaDTO("Loja com o ID " + id + " deletada");
		
		
	}

	


}
