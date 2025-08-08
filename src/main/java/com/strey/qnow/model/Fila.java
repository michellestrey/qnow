package com.strey.qnow.model;

import java.time.LocalDateTime;

import com.strey.qnow.enums.StatusFila;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "filas")
public class Fila {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFila;
	
	@Column(nullable = false)
	private String filaPrincipal;
	
	@Column(name = "criada_em", nullable =false, updatable = false)
	private LocalDateTime criadaEm;
	@Column(name = "alterada_em", nullable = true)
	private LocalDateTime alteradaEm;
	@Column(name = "finalizada_em", nullable = true)
	private LocalDateTime finalizadaEm;
	
	@PrePersist
	public void prePersist() {
	    criadaEm = LocalDateTime.now();
	    
	}
	
	@PreUpdate
	public void preUpdate() {
		alteradaEm = LocalDateTime.now();
	}
	
	@ManyToOne
	private Loja loja;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private StatusFila status = StatusFila.INATIVA;

}
