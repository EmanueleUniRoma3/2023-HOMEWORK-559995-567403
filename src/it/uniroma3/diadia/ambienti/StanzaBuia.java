package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzo;

	public StanzaBuia(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.attrezzo = "lanterna"; //nome attrezzo per vedere dentro la stanza non buia
	}

	@Override
	public String getDescrizione(){
		return stampa();
	}


	public String stampa() {

		if (this.hasAttrezzo(this.attrezzo)) {
			//se è presente l'attrezzo allora gli ritorno la descrizione della stanza
			return super.getDescrizione();
		}
		else 
			//se non c'è l'attrezzo allora non posso vedere 
			return "Qui c'è buio pesto, ti serve la " + this.attrezzo + "."; 


	}



}