package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;
	private IO io;


	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}


	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			Stanza StanzaCorrente = partita.getGiocatore().getPosizione();
			StanzaCorrente.addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

/**
 * un mago quando riceve un regalo dimezza il peso e lo ributta nella stanza
 */
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		Stanza stanzaCorrente = partita.getGiocatore().getPosizione();
		io = partita.getIO();
		
		//dimezza peso
		if(attrezzo.getPeso() >= 2) {
		io.mostraMessaggio("Grazie per il regalo, ma a me non serve. Ma visto il tuo pensiero, \nora ti faccio io un regalo. ");
		attrezzo.setPeso(attrezzo.getPeso()/2);
		}
		else
			io.mostraMessaggio("Il peso è troppo basso, non posso diminuirgli il peso.");
		//aggiungo in stanza
		stanzaCorrente.addAttrezzo(attrezzo);
		
		return "Ecco a te !";
	}



}
