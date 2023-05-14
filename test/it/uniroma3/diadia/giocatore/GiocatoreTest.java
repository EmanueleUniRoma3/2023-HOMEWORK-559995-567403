package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;


class GiocatoreTest {
	
	private IO io;
	
	private Giocatore giocatore;
	private Giocatore giocatore0cfu;
	private Partita partita; 
	private Labirinto labirinto;
	
	@BeforeEach 
	
	
	public void setUp() {
		
		this.io = new IOConsole();
		
		
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanza("N10")
				.getLabirinto();
		
		this.partita = new Partita(labirinto, io);
		
		this.giocatore = this.partita.getGiocatore();
		
	}

	@Test
	void testGetCfuIniziali() {
		assertEquals(20, this.giocatore.getCfuGioc());
	}
	
	
	@Test
	void testGet0Cfu() {
		this.giocatore.setCfuGioc(0);
		assertEquals(0, this.giocatore.getCfuGioc());
	}
	
	@Test
	void testGetPosizioneIniziale() {
		assertEquals(this.labirinto.getStanze().get("Atrio") , this.giocatore.getPosizione());
	}
	
	@Test
	void testSetPosizioneIniziale() {
		this.giocatore.setPosizione(this.labirinto.getStanze().get("N10")); 
		assertEquals(this.labirinto.getStanze().get("N10") , this.giocatore.getPosizione());
		assertNotEquals(this.labirinto.getStanze().get("Atrio") , this.giocatore.getPosizione());
	}
	
}

