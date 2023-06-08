package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

	private Stanza iniziale;
	private Stanza finale;

	private Labirinto(String nomeFile) throws FormatoFileNonValidoException, FileNotFoundException {
		CaricatoreLabirinto c =  new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.iniziale = c.getStanzaIniziale();
		this.finale = c.getStanzaVincente();
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}

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


	
	public static class LabirintoBuilder {

		private Labirinto labirinto;
		public Map<String, Stanza> stanze;

		
		public LabirintoBuilder (String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(nomeFile);
			this.stanze = new HashMap<>();
		}

		
		public Map<String, Stanza> getStanze() {
			return this.stanze;
		}

		public void setStanze(Map<String, Stanza> stanze) {
			this.stanze = stanze;
		}
		

		public LabirintoBuilder addStanzaIniziale(String nome) {

			Stanza iniziale = new Stanza(nome); //creo la stanza iniziale
			labirinto.setStanzaIniziale(iniziale); //setto la stanza iniziale
			this.stanze.put(nome, iniziale); //l'aggiungo al gruppo di stanze

			return this;
		}

		public LabirintoBuilder addStanzaFinale(String nome) {

			Stanza finale = new Stanza(nome);
			labirinto.setUscita(finale);
			this.stanze.put(nome, finale);

			return this;
		}

		public LabirintoBuilder addStanza(String nome) {

			this.stanze.put(nome, new Stanza(nome));

			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String passeparout) {

			Stanza stanza = new StanzaBloccata(nome, direzione, passeparout);
			this.stanze.put(nome, stanza);

			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome) {

			Stanza stanza = new StanzaBuia(nome);
			this.stanze.put(nome, stanza);

			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {

			Stanza stanza = new StanzaMagica(nome);
			this.stanze.put(nome, stanza);

			return this;
		}



		public LabirintoBuilder addAttrezzo(String nomeStanza, String nomeAttrezzo, int peso) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			Stanza stanzaRicercata = this.stanze.get(nomeStanza);

			if(stanzaRicercata != null)
				stanzaRicercata.addAttrezzo(attrezzo);


			return this;
		}

		public LabirintoBuilder addAdiacenza(String nomePartenza, String nomeArrivo, String direzione) {

			Stanza partenza = this.stanze.get(nomePartenza);
			Stanza arrivo = this.stanze.get(nomeArrivo);
			if(partenza != null)
				partenza.impostaStanzaAdiacente(direzione, arrivo);

			return this;
		}

		public LabirintoBuilder setPersonaggioMago(String nomeStanza, String nomeMago, String presentazione, Attrezzo attrezzo ) {
			
			AbstractPersonaggio mago = new Mago(nomeMago, presentazione, attrezzo);
			Stanza stanzaRicercata = this.stanze.get(nomeStanza);
			stanzaRicercata.setPersonaggio(mago);
			
			return this;
		}

		public LabirintoBuilder setPersonaggioCane(String nomeStanza, String nome, String presentaz, Attrezzo attr ) {
			
			AbstractPersonaggio cane = new Cane(nome, presentaz, attr);
			Stanza stanzaRicercata = this.stanze.get(nomeStanza);
			stanzaRicercata.setPersonaggio(cane);
			
			return this;
		}

		public LabirintoBuilder setPersonaggioStrega(String nomeStanza,  String nome, String presentaz) {
			
			AbstractPersonaggio strega = new Strega(nome, presentaz);
			Stanza stanzaRicercata = this.stanze.get(nomeStanza);
			stanzaRicercata.setPersonaggio(strega);
			
			return this;	
		}

		public Labirinto getLabirinto() {
			return labirinto;
		}
	}

}
