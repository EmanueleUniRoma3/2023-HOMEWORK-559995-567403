package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.IO;

public class Giocatore {

	//gestisce i cfu del giocatore e memorizza attrezzi in un oggetto istanza della classe Borsa

	private int cfu;
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa; 
	public IO io;

	public Giocatore (IO Ioconsole) {
		this.cfu = CFU_INIZIALI;
		this.io = Ioconsole;
		this.borsa  = new Borsa(Ioconsole);
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


}
