package com.btg.jokenpo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btg.jokenpo.domain.model.Jogador;

@Repository 
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}
