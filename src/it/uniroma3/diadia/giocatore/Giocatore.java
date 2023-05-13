package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class Giocatore {

	//gestisce i cfu del giocatore e memorizza attrezzi in un oggetto istanza della classe Borsa

	private int cfu;
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa; 
	public IO io;
	public Stanza stanzaCorrente;

	public Giocatore (IO Ioconsole, Stanza iniziale) {
		this.cfu = CFU_INIZIALI;
		this.io = Ioconsole;
		this.borsa  = new Borsa(Ioconsole);
		this.stanzaCorrente = iniziale; // gli do la stanza iniziale in cui si trova passsato da partita
	}

	//devo gestire i cfu del giocatore
	public int getCfuGioc() {
		return this.cfu;	
	}

	public void setCfuGioc(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setPosizione(Stanza stanza){
		this.stanzaCorrente = stanza;
	}

	public Stanza getPosizione() {
		return this.stanzaCorrente;
	}

}
