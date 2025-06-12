package com.strey.qnow.dto.gerentdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateGerenteDTO {
	
	
	@NotBlank
	private String nome;
	@NotBlank
	@Size(max=100)
	private String email;
	@NotBlank
    @Size(min=3)
	private String senha;

}
