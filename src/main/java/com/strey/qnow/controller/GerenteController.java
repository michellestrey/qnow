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

import com.strey.qnow.dto.gerentedto.CreateGerenteDTO;
import com.strey.qnow.dto.gerentedto.ResponseGerenteDTO;
import com.strey.qnow.dto.gerentedto.UpdateGerenteDTO;
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


	@GetMapping("/busca-id")
	public ResponseEntity<ResponseGerenteDTO> buscaId(@PathVariable Long id){
		ResponseGerenteDTO dto = gerenteService.buscaId(id);
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

      @DeleteMapping("/delete-id")
      public ResponseEntity<Void> delete(@PathVariable Long id){
    	  gerenteService.deletarPorId(id);
    	  return ResponseEntity.noContent().build();
      }


   @PutMapping("/atualiza-id")
   public ResponseEntity<ResponseGerenteDTO> atualiza(@PathVariable Long id, @RequestBody UpdateGerenteDTO upDTO){
	   ResponseGerenteDTO atualizado = gerenteService.atualizarGerente(id, upDTO);
	   return ResponseEntity.ok(atualizado);
	   
   }



}
