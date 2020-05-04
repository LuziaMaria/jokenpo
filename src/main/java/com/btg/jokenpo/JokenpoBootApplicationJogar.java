package com.btg.jokenpo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.btg.jokenpo.domain.model.Entrada;
import com.btg.jokenpo.domain.model.Jogador;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.btg.jokenpo")
public class JokenpoBootApplicationJogar {

	 private final static String URI = "http://localhost:8080/";
		 
	public static void main(String[] args) {
		
		SpringApplication.run(JokenpoApiApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();

		// listando entradas
		Entrada[] entradas = restTemplate.getForObject(
				  		URI + "entradas", Entrada[].class);

		Jogador vencedor = new Jogador(); 

		for(int i=0; i<entradas.length;i++) {
			
			System.out.println("Jogador = " + entradas[i].getJogador().getId() + " - " + entradas[i].getJogador().getNome() + 
						       " Tipo Jogada = " + entradas[i].getTipoJogada().getDescricao());
			
			if (i>0) {
				for (int j=0; j<entradas.length;j++) {
					if (entradas[j].getTipoJogada().getId() == entradas[i].getTipoJogada().getIdVitoria1() || 
						entradas[j].getTipoJogada().getId() == entradas[i].getTipoJogada().getIdVitoria2() ) {
						 	vencedor.setId(entradas[i].getJogador().getId());
						 	vencedor.setNome(entradas[i].getJogador().getNome());
					}
				}
			} else {
				vencedor.setId(entradas[i].getJogador().getId());
			 	vencedor.setNome(entradas[i].getJogador().getNome());
			}
		}
		
		System.out.println(" Resultado  - Jogador -  " + vencedor.getId() + " - " + vencedor.getNome() + " -  Vitoria " );
	}
	
}
