package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	IO io;
	AbstractPersonaggio personaggio;
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		io = partita.getIO();
		personaggio = partita.getGiocatore().getPosizione().getPersonaggio();

		io.mostraMessaggio("Salve, sono un giocatore della partita. ");
		
		io.mostraMessaggio(personaggio.saluta());
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Saluta";
	}

	@Override
	public String getMessaggio() {
		// TODO Auto-generated method stub
		return null;
	}

}
