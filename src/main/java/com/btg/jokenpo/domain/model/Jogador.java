package com.btg.jokenpo.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jogador")
public class Jogador  implements Serializable  {
  
	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_JOGADOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@JsonIgnore
	@OneToOne
	private Entrada entrada;
}
