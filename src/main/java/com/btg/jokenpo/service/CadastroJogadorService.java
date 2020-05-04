package com.btg.jokenpo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.jokenpo.domain.exceptions.EntidadeEmUsoException;
import com.btg.jokenpo.domain.exceptions.EntidadeNaoEncontradaException;
import com.btg.jokenpo.domain.model.Jogador;
import com.btg.jokenpo.domain.repository.JogadorRepository;

@Service
public class CadastroJogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	public Jogador buscarPorId(Long id) {
		Optional<Jogador> jogador = jogadorRepository.findById(id);
		if (!jogador.isEmpty()) {
			return jogador.get();
		} else {
			throw new EntidadeNaoEncontradaException(
			String.format("Não existe um cadastro de jogador com código %d", id));
		}
	}
	
	public List<Jogador> listar() {
		 return jogadorRepository.findAll();
	}
	
	public Jogador salvar(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}
	
	public void remover(Long jogadorId) {

		try {
			Jogador jogador = this.buscarPorId(jogadorId);
			jogadorRepository.deleteById(jogador.getId());
		} catch (EntidadeNaoEncontradaException  e) {
			throw e;	
		} catch (EntidadeEmUsoException e) {
			throw e;
		}
	}
}
