package com.strey.qnow.dto.gerentdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class CreateGerenteDTO {
	
	
	@NotBlank
	@Size(min =3, max = 100)
	private String nome;
	@NotBlank
	@Email(message = "E-mail é obrigatório")
	@Size(max=100)
	private String email;
	@NotBlank(message = "Senha é obrigatória")
	@Size(min=3)
	private String senha;

}
