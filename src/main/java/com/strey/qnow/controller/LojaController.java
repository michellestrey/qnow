package com.strey.qnow.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strey.qnow.dto.lojadto.CreateLojaDTO;
import com.strey.qnow.dto.lojadto.ResponseLojaDTO;
import com.strey.qnow.dto.lojadto.UpdateLojaDTO;
import com.strey.qnow.service.LojaService;

@RestController
@RequestMapping("/loja")
public class LojaController {
	
	private final LojaService lojaService;
	
	public LojaController(LojaService lojaService) {
		this.lojaService = lojaService;
	}

	
	@PostMapping("/cadastra-loja")
	public ResponseEntity<ResponseLojaDTO> cadastrarLoja(@RequestBody CreateLojaDTO dto){
		  var response = lojaService.cadastrarLoja(dto);
		  return ResponseEntity.status(201).body(response);	
	}
	
	@GetMapping("listar-lojas")
	public ResponseEntity<List<ResponseLojaDTO> >listarLojas(){
		List<ResponseLojaDTO> lojas = lojaService.listarLojas();
			if(lojas.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		 return ResponseEntity.ok(lojas);
	}
	
	@GetMapping("/listar-loja-id/{id}")
	public ResponseEntity<ResponseLojaDTO> listarLoja(@PathVariable Long id){
		ResponseLojaDTO lojaDTO = lojaService.buscarId(id);
		if(lojaDTO != null) {
			return ResponseEntity.ok(lojaDTO);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	
	@PutMapping("/atualiza-loja-id/{id}")
	public ResponseEntity<ResponseLojaDTO> atualizaLoja(@PathVariable Long id, @RequestBody UpdateLojaDTO dto){
		 ResponseLojaDTO lojaAtualizada = lojaService.atualizarLoja(id, dto);
		 return ResponseEntity.ok(lojaAtualizada);
		
	}
	
	@DeleteMapping("/deleta-loja-id/{id}")
	public ResponseEntity<Void> deletaLoja(@PathVariable Long id){
		lojaService.deletarLojaPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
