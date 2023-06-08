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
	private Labirinto lab; 
	private Stanza stanzaVincente;
	public IO io;


	//quando creo una partita di conseguenza creo: Giocatore, un Labirinto
	public Partita(Labirinto labirinto ,IO IOconsole){
		this.finita = false;
		this.io = IOconsole;
		//this.labirinto = new LabirintoBuilder();//quando creo la partito devo creare il labirinto, che avrà delle stanze di default
		this.lab = labirinto;
		this.giocatore = new Giocatore(IOconsole, lab.getStanzaIniziale()); //quando creo la partita creo anche un giocatore 
		this.stanzaVincente = lab.getUscita();
	}


	public IO getIO() {
		return this.io;
	}

	//per riprendere dalla partita il riferimento di giocatore
	public Giocatore getGiocatore() {
		return this.giocatore;	
	}

	//per riprendere dalla partita il riferimento di Labirinto
	public Labirinto getLabirinto() {
		return this.lab;
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
		return this.giocatore.getPosizione() == this.stanzaVincente ;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		if (vinta()) {
			io.mostraMessaggio("Hai raggiunto la stanza vincente ! ");
			return true;		
		}
		else if (this.giocatore.getCfuGioc() == 0) {
			io.mostraMessaggio("Hai esaurito i crediti. Mi spiace, hai preso !");
			return true;
		}
		else if (finita)
			return true;
		else
			return false;
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}

