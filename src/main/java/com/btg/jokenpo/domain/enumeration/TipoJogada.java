package com.btg.jokenpo.domain.enumeration;

public enum TipoJogada {

	SPOCK(1,"Spock", 2, 4),
	TESOURA(2,"Tesoura", 5, 3),
	PAPEL(3,"Papel", 1, 4),
	PEDRA(4,"Pedra", 2, 5),
	LAGARTO(5,"Lagarto", 3, 1);
	
	private int id;
	private String descricao;
	private Integer idVitoria1;
	private Integer idVitoria2;
	
	private TipoJogada vitoria;
	
	private TipoJogada(int indice, String descricao, Integer vitoria1, Integer vitoria2) {
		this.id = indice;
		this.descricao = descricao;
		this.idVitoria1 = vitoria1;
		this.idVitoria2 = vitoria2;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getIdVitoria1() {
		return idVitoria1;
	}

	public Integer getIdVitoria2() {
		return idVitoria2;
	}

	public TipoJogada getVitoria(Integer id) {
		
		TipoJogada vitoria = null;
		for (TipoJogada tj : TipoJogada.values()) {
			if (tj.id == id) {
				this.setVitoria(tj);
				break;
			}
		}
		return vitoria;
	}

	public void setVitoria(TipoJogada vitoria) {
		this.vitoria = vitoria;
	}
	
}
