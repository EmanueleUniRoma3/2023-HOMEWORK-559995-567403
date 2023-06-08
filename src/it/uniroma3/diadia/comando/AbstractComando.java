package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractComando {
	
	String parametro = null;
	
	//queste due funzioni verranno eseguite in maniera diversa da tutti i comandi
	public abstract void esegui(Partita partita);

	public abstract String getNome();
		
	public abstract String getMessaggio(); 
	
	public String getParametro() {
		return this.parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	
}
