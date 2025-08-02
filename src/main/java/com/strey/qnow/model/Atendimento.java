package com.strey.qnow.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "atendimento")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id", nullable = false)//CRIA FK NO DB
	private Vendedor vendedor;
	
	@Column(nullable = false)
	private LocalDateTime horaInicio;
	
	@Column(nullable = false)
	private LocalDateTime horaFim;
	
	@Column(nullable = false)
	private boolean houveConversao;
	
	@ManyToOne
	@JoinColumn(name = "loja_id", nullable = false)
	private Loja loja;
	

	
	
	
	

}
