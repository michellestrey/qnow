package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strey.qnow.model.Atendimento;
import com.strey.qnow.repository.AtendimentoRepository;

import jakarta.transaction.Transactional;

@Service
public class AtendimentoService {


	private final AtendimentoRepository atendimentoRepository;
	
	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}
	
	
	@Transactional
	public Atendimento cadastrarAtendimento(Atendimento atendimento) {
		atendimentoRepository.findById(atendimento.getId())
						.ifPresent(a -> {
							throw new RuntimeException("Atendimento já cadastrado!");
						});
		return atendimentoRepository.save(atendimento);
		
	}
	
	public List<Atendimento> listAll(){
		return atendimentoRepository.findAll();
	}
	
	public Optional<Atendimento> buscaId(Long id){
		return atendimentoRepository.findById(id);
	}
	
	
	
	
}
