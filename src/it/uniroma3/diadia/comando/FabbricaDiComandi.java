package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

public interface FabbricaDiComandi {

	//primo metodo dell'interface
	public Comando costruisci(String nomeComando);	
	public void setPartita(Partita partita);
}
