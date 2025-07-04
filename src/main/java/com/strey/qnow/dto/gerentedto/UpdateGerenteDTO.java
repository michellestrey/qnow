package com.strey.qnow.dto.gerentedto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateGerenteDTO {
	
	
	@NotBlank
	@Size(min=3)
	private String nome;
	@NotBlank
	@Size(max=100)
	private String email;
	@NotBlank
    @Size(min=3)
	private String senha;

}
