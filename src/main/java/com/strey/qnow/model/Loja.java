package com.strey.qnow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length =100)
	private String nome;
	
	@Column(length = 200)
	private String endereco;
	
	@Column(unique = true, length = 18)//tamanho máximo de 18 incluindo caracteres (00.000.000/0000-00)
    private String cnpj;
	

}
