package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String nomeDirezioneBloccata;

	private String chiave;

	//private Labirinto labirinto;


	public StanzaBloccata(String nome, String dirBloccata, String passepartout) {

		super(nome);
		this.chiave = passepartout;
		this.nomeDirezioneBloccata = dirBloccata;

	}


	public String getNomeDirezioneBloccata() {

		return nomeDirezioneBloccata;

	}

	public void setNomeDirezioneBloccata(String nomeDirezioneBloccata) {

		this.nomeDirezioneBloccata = nomeDirezioneBloccata;

	}

	public String getChiave() {

		return this.chiave;

	}

	public void setAttrezzoSbloccante(String attrezzoSbloccante) {

		this.chiave = attrezzoSbloccante;

	}



	/*

	 * una delle direzioni della stanza non può essere seguita a meno che

nella stanza non sia presente un oggetto con un

nome particolare (ad esempio "passepartout")*/

	@Override
	public String getDescrizione() {
		
			return "La direzione "+ this.nomeDirezioneBloccata + " è bloccata!"
					+ "\nHai bisogno del Passepartout: " + this.chiave + ".\n" + super.getDescrizione()  ;
		}



	public boolean trovaPassepartout() {

		return this.hasAttrezzo(this.chiave);

	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {

		//se la direzione che richiedo è quella bloccata allora 
		if (dir.equals(nomeDirezioneBloccata))
			//faccio il controllo se ho la chiave
			if(this.trovaPassepartout()){ 
			//e ritorno la stanza adiacente	
			return super.getStanzaAdiacente(dir);

		} else {

			return this; // ritorna questa stanza bloccata
		}
		else //se non è la direzione bloccata 
			return super.getStanzaAdiacente(dir);

	}
}
