package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai implements Comando {

	private String direzione;


	@Override
	public void esegui(Partita partita) {

		IO io = partita.getIO();

		if(this.direzione == null) {

			io.mostraMessaggio("Direzione inesistente! Dove vuoi andare ?");

			return;
		}

		Stanza prossimaStanza = null;
		prossimaStanza = partita.getLabirinto().getStanze().get(direzione);

		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		//altrimenti se richiamo la funzione di stanza bloccata e mi ritorna la stesssa perchè la direzione è blocccata 
		//allora stampo Direzione Bloccata e la descrizione
		else if (prossimaStanza.equals(partita.getGiocatore().getPosizione()))
			io.mostraMessaggio("Mi spiace direzione bloccata, riprova! ");

		else {
			partita.getGiocatore().setPosizione(prossimaStanza);
			int cfu = partita.getGiocatore().getCfuGioc();
			partita.getGiocatore().setCfuGioc(--cfu);

		}

		io.mostraMessaggio("Cfu giocatore: "+ partita.getGiocatore().getCfuGioc());
		io.mostraMessaggio(partita.getGiocatore().getPosizione().getDescrizione());
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione = parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Vai";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}


}
