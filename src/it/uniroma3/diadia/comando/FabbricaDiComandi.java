package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

public interface FabbricaDiComandi {

	//primo metodo dell'interface
	public AbstractComando costruisci(String nomeComando)
			throws Exception;

	
	
	public void setPartita(Partita partita);
	
}
