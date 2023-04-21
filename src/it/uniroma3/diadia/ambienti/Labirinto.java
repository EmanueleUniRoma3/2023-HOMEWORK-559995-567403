package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	public Stanza stanzaCorrente;
	private Stanza uscita;

	//inizializzo il labirinto
	public Labirinto() {
		creaStanze();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	private void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",5);
		Attrezzo osso = new Attrezzo("osso",3);
		Attrezzo chiodo = new Attrezzo("chiodo",1);
		Attrezzo passepartout = new Attrezzo("passepartout",1);

		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBloccata("Atrio", "nord", "passepartout");
		Stanza aulaN11 = new StanzaBuia("Aula N11");
		Stanza aulaN10 = new StanzaMagica("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
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

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(chiodo);
		aulaN11.addAttrezzo(passepartout);

		// il gioco comincia nell'atrio
		stanzaCorrente = atrio;
	}


	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public Stanza getUscita() {
		return this.uscita;
	}

	public void setUscita(Stanza stanza) {
		this.uscita = stanza;
	}


}
