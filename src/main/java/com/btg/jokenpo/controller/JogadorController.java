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

import com.btg.jokenpo.domain.model.Jogador;
import com.btg.jokenpo.service.CadastroJogadorService;

@CrossOrigin("*")
@RestController
@RequestMapping("jogadores")
public class JogadorController {

	@Autowired
	private CadastroJogadorService cadastroJogador;
	
	@GetMapping
	public List<Jogador> list() {
		return cadastroJogador.listar();
	}
	
	@GetMapping("/{jogadorId}")
	public ResponseEntity<Jogador> buscar(@PathVariable Long jogadorId) {
		
		Jogador jogador = cadastroJogador.buscarPorId(jogadorId);
		
		if (jogador != null ) {
			return ResponseEntity.ok(jogador);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Jogador adicionar(@RequestBody Jogador jogador) {
		return cadastroJogador.salvar(jogador);
	}
	
	@DeleteMapping("/{jogadorId}") 
	public ResponseEntity<?> remover(@PathVariable Long jogadorId ) {
			cadastroJogador.remover(jogadorId);
			return ResponseEntity.noContent().build();
	
	}
	
}
