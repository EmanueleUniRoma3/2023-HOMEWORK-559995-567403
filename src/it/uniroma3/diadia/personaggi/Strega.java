package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Strega extends AbstractPersonaggio {	


	Attrezzo att;
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		this.att = null;
	}



	/**
	 * se non l’abbiamo ancora salutata, ci «trasferisce» nella 
	   stanza adiacente che contiene meno attrezzi
       altrimenti in quella che contiene più attrezzi
	 */
	@Override
	public String agisci(Partita partita) {

		Stanza stanzaCorrente = partita.getGiocatore().getPosizione();
		List<Stanza> stanzeAdiacenti = new ArrayList<>(stanzaCorrente.getStanzeAdiacenti().values());
		Giocatore giocatore = partita.getGiocatore();
		Stanza migliore = null , peggiore = null;

		int contaAttrezzi = 0;

		if(this.haSalutato()) {
			for(Stanza s : stanzeAdiacenti) {
				if(contaAttrezzi < s.getNumeroAttrezzi()) {
					contaAttrezzi = s.getNumeroAttrezzi();
					migliore = s;
				}					
			}
			giocatore.setPosizione(migliore);			

			return "Oggi è il tuo giorno fortunato!";
		}

		else {
			for(Stanza s : stanzeAdiacenti) {
				if(contaAttrezzi > s.getNumeroAttrezzi()) {
					contaAttrezzi = s.getNumeroAttrezzi();
					peggiore = s;
				}					
			}
			giocatore.setPosizione(peggiore);		

			return "La prossima volta ti conviene salutare prima !! ";
		}
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

		this.att = attrezzo;
		
		return " ahahahahahhahahaha ";
	}

}
