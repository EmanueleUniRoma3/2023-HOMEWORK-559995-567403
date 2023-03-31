package it.uniroma3.diadia.giocatore;

public class Giocatore {

	//gestisce i cfu del giocatore e memorizza attrezzi in un oggetto istanza della classe Borsa

	private int cfu;
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa; 


	public Giocatore () {
		this.cfu = CFU_INIZIALI;
		this.borsa  = new Borsa();
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
