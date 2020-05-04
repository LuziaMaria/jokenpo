package com.btg.jokenpo.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.btg.jokenpo.domain.enumeration.TipoJogada;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="entrada")
public class Entrada implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_ENTRADA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Jogador jogador;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_JOGADA", length = 10)
	private TipoJogada tipoJogada;
}
