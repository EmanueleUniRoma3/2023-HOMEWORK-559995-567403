package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza stanzaVincente;



	//quando creo una partita di conseguenza creo: Giocatore, un Labirinto
	public Partita(){
		this.finita = false;
		this.giocatore = new Giocatore(); //quando creo la partita creo anche un giocatore 
		this.labirinto = new Labirinto(); //quando creo la partito devo creare il labirinto, che avrà delle stanze di default
		this.stanzaVincente = labirinto.getUscita();
	}
	

	//per riprendere dalla partita il riferimento di giocatore
	public Giocatore getGiocatore() {
		return this.giocatore;	
	}

	//per riprendere dalla partita il riferimento di Labirinto
	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente = stanza;
	}

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta getStanzaVincente()
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente() == labirinto.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfuGioc()== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}

