package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		IO io = partita.getIO();

		//devo eliminare dalla borsa e posare nella stanza
		Borsa borsa = partita.getGiocatore().getBorsa();

		Stanza stanzaCorrente = partita.getGiocatore().getPosizione();

		if (nomeAttrezzo != null) {

			if (borsa != null && stanzaCorrente != null) {
				Attrezzo att = borsa.removeAttrezzo(nomeAttrezzo);
				if (att!= null) {
					//devo aggiungere in stanza
					stanzaCorrente.addAttrezzo(att);
					//ora ho inserito in stanza corrente l'attrezzo
					io.mostraMessaggio("Attrezzo aggiunto in stanza: " + stanzaCorrente.getNome());
				}
			}
		}
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Posa";
	}


	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
