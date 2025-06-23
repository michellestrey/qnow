package com.strey.qnow.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loja")
@Getter @Setter @NoArgsConstructor
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length =100)
	private String nome;
	
	@Column(length = 200, nullable = false, unique = true)
	private String endereco;
	
	@Column(unique = true, length = 18, nullable = false)//tamanho máximo de 18 incluindo caracteres (00.000.000/0000-00)
    private String cnpj;
	
	@Column(length= 200, unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false, length = 200)
	private String senha; 
	
	@OneToMany(mappedBy = "loja")
	private List<Gerente> gerentes;
	
	@OneToMany(mappedBy = "loja")
	private List<Vendedor> vendedores;
	
	@OneToMany(mappedBy = "loja")
	private List<Atendimento>atendimentos;
	

}
