package com.strey.qnow.dto.lojadto;

import java.util.List;

import com.strey.qnow.model.Gerente;
import com.strey.qnow.model.Vendedor;

public record ResponseLojaDetalhadaDTO(
		
	String nome,
	String cnpj,
	String email,
	String endereco,
	List<Gerente> gerentes,
	List<Vendedor> vendedores		
		) {

}
