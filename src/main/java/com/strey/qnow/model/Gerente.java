package com.strey.qnow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "gerente")
@Getter @Setter @NoArgsConstructor
public class Gerente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100, unique = true)
	private String nome;
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@OneToOne(mappedBy = "gerente")
	private Loja loja;
	
	

}
