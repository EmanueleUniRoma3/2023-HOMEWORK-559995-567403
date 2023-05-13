package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	public Map<String, Stanza> stanze;
	private List<Attrezzo> attrezzi;
	private Stanza iniziale;
	private Stanza finale;
	
	
	//creo il labirinto
	public Labirinto() {
		this.stanze = new HashMap<>();
		this.attrezzi = new ArrayList<>();
	}
	
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	/*private void creaStanze() {

	
		Attrezzo lanterna = new Attrezzo("lanterna",5);
		Attrezzo osso = new Attrezzo("osso",3);
		Attrezzo chiodo = new Attrezzo("chiodo",1);
		Attrezzo passepartout = new Attrezzo("passepartout",1);

		
		Stanza atrio = new StanzaBloccata("Atrio", "nord", "passepartout");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		setUscita(biblioteca);

		
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(chiodo);
		aulaN10.addAttrezzo(passepartout);

		
		stanzaCorrente = atrio;
	}

*/

	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.iniziale = stanzaIniziale;
	}

	public Stanza getStanzaIniziale() {
		return this.iniziale;
	}

	public Stanza getUscita() {
		return this.finale;
	}

	public void setUscita(Stanza stanza) {
		this.finale = stanza;
	}
	
	public Map<String, Stanza> getStanze() {
		return this.stanze;
	}
	
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}
	
	public void setStanze(Map<String, Stanza> stanze) {
		this.stanze = stanze;
	}



}
