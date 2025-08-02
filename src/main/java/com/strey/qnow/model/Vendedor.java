package com.strey.qnow.model;



import java.util.List;

import com.strey.qnow.enums.StatusVendedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "vendedor")
@Data
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length =100)
	private String nome; 
	
	@Column(nullable = false, length =100)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable =false)
	private StatusVendedor status = StatusVendedor.INDISPONIVEL;
	
	@OneToMany(mappedBy = "vendedor")
	private List<Atendimento> atendimentos;	
	
	@ManyToOne
	@JoinColumn(name = "loja_id", nullable = false)
	private Loja loja;


	

}
