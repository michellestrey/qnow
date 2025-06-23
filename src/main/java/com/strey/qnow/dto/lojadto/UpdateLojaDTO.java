package com.strey.qnow.dto.lojadto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateLojaDTO {
	
	
	@NotBlank
	@Size(min= 3)
	String nome;
	@NotBlank
	@Size(min=3)
	String endereco;
	@NotBlank
	@Size(max=50)
	String cnpj;
	@NotBlank
	@Size(max=200)
	String email;
	@NotBlank
	@Size(max=200)
	String senha;

}
