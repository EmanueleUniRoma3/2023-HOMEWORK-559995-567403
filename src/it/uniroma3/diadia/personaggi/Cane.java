package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Cane extends AbstractPersonaggio {

	Attrezzo attrezzoCane;

	public Cane(String nome, String presentaz, Attrezzo attr) {
		super(nome, presentaz);
		this.attrezzoCane = attr;
	}

	@Override
	public String agisci(Partita partita) {

		Giocatore giocatore = partita.getGiocatore();
		int cfu = giocatore.getCfuGioc();
		giocatore.setCfuGioc(--cfu);

		return "Il cane ti ha morso, hai perso un CFU. Ora ne hai: " + giocatore.getCfuGioc() + " .";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

		Stanza stanzaCorrente = partita.getGiocatore().getPosizione();
		

		if(attrezzo.getNome().equals("croccantini")) {
			if(this.attrezzoCane != null)
				stanzaCorrente.addAttrezzo(this.attrezzoCane);
		}	
			else {
				return this.agisci(partita);
			}
		

		return "Oh guarda il cane ha lsciato qualcosa per terra! ";
	}
}
