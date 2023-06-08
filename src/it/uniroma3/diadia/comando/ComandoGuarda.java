package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

//	stampa le informazioni sulla stanza corrente e sullo stato della 
//	partita
//Quindi voglio sapere CFU, Nome della Stanza, 

public class ComandoGuarda extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		IO io = partita.getIO();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		io.mostraMessaggio(borsa.toString()); //mi da l'elenco degli attrezzi
		io.mostraMessaggio("Cfu giocatore: " + partita.getGiocatore().getCfuGioc()); //Vedo i CFU del Giocatore
		io.mostraMessaggio(partita.getGiocatore().getPosizione().getDescrizione()); //Vedo il nome della stanzaCorrente
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Guarda";
	}

	@Override
	public String getMessaggio() {
		// TODO Auto-generated method stub
		return null;
	}

}
