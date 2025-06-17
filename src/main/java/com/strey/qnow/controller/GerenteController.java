package com.strey.qnow.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strey.qnow.dto.gerentedto.CreateGerenteDTO;
import com.strey.qnow.dto.gerentedto.ResponseGerenteDTO;
import com.strey.qnow.service.GerenteService;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
	
	
	private final GerenteService gerenteService;
	
	public GerenteController(GerenteService gerenteService) {
		this.gerenteService = gerenteService;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ResponseGerenteDTO> cadastrar(@RequestBody CreateGerenteDTO dto){
		var response = gerenteService.cadastrar(dto);
		return ResponseEntity.status(201).body(response);
		
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<ResponseGerenteDTO>> listar(){
		List<ResponseGerenteDTO> gerentes = gerenteService.listarTodos();
		if(gerentes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(gerentes);
	}
	
	
	
	

}
