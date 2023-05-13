package it.uniroma3.diadia;

import java.util.LinkedList;
import java.util.List;

public class IOSimulator implements IO{
	private List<String> righeDaLeggere;
	private List<String> stampeEffettuate;
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.stampeEffettuate = new LinkedList<String>();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.stampeEffettuate.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		if(!this.righeDaLeggere.isEmpty())
			return this.righeDaLeggere.remove(0);
		return null;
	}
	
	public String nextMessaggio() {
		if(!this.stampeEffettuate.isEmpty())
			return this.stampeEffettuate.remove(0);
		return null;
	}
}
