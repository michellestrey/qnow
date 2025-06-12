package com.strey.qnow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public Loja cadastrarLoja(Loja loja){
		getLojaRepository().findById(loja.getId())
		.ifPresent(l ->{
			throw new RuntimeException("Loja já cadastrada!");
		});
		return getLojaRepository().save(loja);

	}

	public List<Loja>listarLojas() {
		return getLojaRepository().findAll();
	}

	public Optional<Loja> buscarId(Long id){
		return getLojaRepository().findById(id);

	}

	@Transactional
	public Loja atualizarLoja(Long id, Loja atualiza) {
		Loja loja = getLojaRepository().findById(id)
				.orElseThrow(()
						-> new RuntimeException("Id não encontrado: " + id));
		loja.setNome(atualiza.getNome());	
		return getLojaRepository().save(loja); 
	}

	@Transactional
	public String deletarLojaPorId(Long id) {
		getLojaRepository().deleteById(id);
		return "Loja com o ID " + id + " deletada!";
	}

	public LojaRepository getLojaRepository() {
		return lojaRepository;
	}



}
