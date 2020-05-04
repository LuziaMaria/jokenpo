package com.btg.jokenpo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.jokenpo.domain.exceptions.EntidadeEmUsoException;
import com.btg.jokenpo.domain.exceptions.EntidadeNaoEncontradaException;
import com.btg.jokenpo.domain.model.Entrada;
import com.btg.jokenpo.domain.repository.EntradaRepository;

@Service
public class CadastroEntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	
	public Entrada buscarPorId(Long id) {
		Optional<Entrada> entrada = entradaRepository.findById(id);
		if (!entrada.isEmpty()) {
			return entrada.get();
		} else {
			throw new EntidadeNaoEncontradaException(
			String.format("Não existe um cadastro de jogador com código %d", id));
		}
	}
	
	public List<Entrada> listar() {
		 return entradaRepository.findAll();
	}
	
	public Entrada salvar(Entrada entrada) {
		return entradaRepository.save(entrada);
	}
	
	public void remover(Long entradaId) {

		try {
			Entrada entrada = this.buscarPorId(entradaId);
			entradaRepository.deleteById(entrada.getId());
		} catch (EntidadeNaoEncontradaException  e) {
			throw e;	
		} catch (EntidadeEmUsoException e) {
			throw e;
		}
	}
}
