package com.strey.qnow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strey.qnow.model.Vendedor;
import com.strey.qnow.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	private final VendedorService vendedorService;
	
	public VendedorController(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}
	
	@PostMapping
	public ResponseEntity<Vendedor> cadastrar(@RequestBody Vendedor vendedor){
		Vendedor vendedorNovo = vendedorService.cadastrar(vendedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendedorNovo);
	}

	
	
}
