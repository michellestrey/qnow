package com.strey.qnow.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "vendedor")
@Getter @Setter @NoArgsConstructor
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length =100)
	private String nome; 
	
	@Column(nullable = false, length =100)
	private String email;
	
	
	@Column(nullable = false)//gerente que vai definir a disponibilidade
	private boolean disponivel = false;
	
	@OneToMany(mappedBy = "vendedor")
	private List<Atendimento> atendimentos;	
	
	@ManyToOne
	private Loja loja;

	
	

}
