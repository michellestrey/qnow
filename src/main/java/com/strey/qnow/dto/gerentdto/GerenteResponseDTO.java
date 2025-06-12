package com.strey.qnow.dto.gerentdto;

import com.strey.qnow.model.Gerente;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GerenteResponseDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	
	public GerenteResponseDTO(Gerente gerente) {
		this.id = gerente.getId();
		this.nome = gerente.getNome();
		this.email = gerente.getEmail();
	}
	
	

}
