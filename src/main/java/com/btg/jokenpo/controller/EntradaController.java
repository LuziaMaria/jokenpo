package com.btg.jokenpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.btg.jokenpo.domain.model.Entrada;
import com.btg.jokenpo.service.CadastroEntradaService;

@CrossOrigin("*")
@RestController
@RequestMapping("entradas")
public class EntradaController {

	@Autowired
	private CadastroEntradaService cadastroEntrada;
	
	@GetMapping
	public List<Entrada> list() {
		return cadastroEntrada.listar();
	}
	
	@GetMapping("/{entradaId}")
	public ResponseEntity<Entrada> buscar(@PathVariable Long entradaId) {
		
		Entrada entrada = cadastroEntrada.buscarPorId(entradaId);
		
		if (entrada != null ) {
			return ResponseEntity.ok(entrada);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrada adicionar(@RequestBody Entrada entrada) {
		return cadastroEntrada.salvar(entrada);
	}
	
	@DeleteMapping("/{entradaId}") 
	public ResponseEntity<?> remover(@PathVariable Long entradaId ) {
		cadastroEntrada.remover(entradaId);
			return ResponseEntity.noContent().build();
	
	}
}
