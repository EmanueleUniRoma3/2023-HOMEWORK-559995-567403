package it.uniroma3.diadia.comando;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private IO io;
	private Labirinto labirinto;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.comandoPrendi = new ComandoPrendi();
		this.io = new IOConsole();
		
		this.labirinto = new LabirintoBuilder()
				
				.addStanzaIniziale("Atrio")
				.addAttrezzo("Atrio", "torcia", 3)
				.getLabirinto();
		
		this.partita = new Partita(labirinto ,io);
			
	}

	@Test
	void testEseguiComandoPrendi() {
		
			this.comandoPrendi.setParametro("torcia");
			this.comandoPrendi.esegui(this.partita);
			
			assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("torcia"));
			assertFalse(this.partita.getLabirinto().getStanzaIniziale().hasAttrezzo("torcia"));
	}

	@Test
	void testEseguiComandoPrendiSbagliato() {
		
			this.comandoPrendi.setParametro("Spada");
			this.comandoPrendi.esegui(this.partita);
			
			assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Spada"));
	}

	
}
