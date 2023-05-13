package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder  {

	private Labirinto labirinto;

	//creo labirinto
	public LabirintoBuilder () {
		this.labirinto = new Labirinto();
	}


	public LabirintoBuilder addStanzaIniziale(String nome) {

		Stanza iniziale = new Stanza(nome); //creo la stanza iniziale
		labirinto.setStanzaIniziale(iniziale); //setto la stanza iniziale
		labirinto.getStanze().put(nome, iniziale); //l'aggiungo al gruppo di stanze

		return this;
	}

	public LabirintoBuilder addStanzaFinale(String nome) {

		Stanza finale = new Stanza(nome);
		labirinto.setUscita(finale);
		labirinto.getStanze().put(nome, finale);

		return this;
	}

	public LabirintoBuilder addStanza(String nome) {

		labirinto.getStanze().put(nome, new Stanza(nome));

		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String passeparout) {

		Stanza stanza = new StanzaBloccata(nome, direzione, passeparout);
		labirinto.getStanze().put(nome, stanza);

		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome) {

		Stanza stanza = new StanzaBuia(nome);
		labirinto.getStanze().put(nome, stanza);

		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {

		Stanza stanza = new StanzaMagica(nome);
		labirinto.getStanze().put(nome, stanza);

		return this;
	}



	public LabirintoBuilder addAttrezzo(String nomeStanza, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		Stanza stanzaRicercata = labirinto.getStanze().get(nomeStanza);

		if(stanzaRicercata != null)
			stanzaRicercata.addAttrezzo(attrezzo);


		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nomePartenza, String nomeArrivo, String direzione) {
		
		Stanza partenza = labirinto.getStanze().get(nomePartenza);
		Stanza arrivo = labirinto.getStanze().get(nomeArrivo);
		if(partenza != null)
		partenza.impostaStanzaAdiacente(direzione, arrivo);
	
		return this;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

}
