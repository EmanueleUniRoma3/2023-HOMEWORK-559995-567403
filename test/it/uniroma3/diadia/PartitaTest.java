package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.*;

import org.junit.jupiter.api.BeforeEach;


class PartitaTest {
	
	IO io = new IOConsole();
	
	CaricatoreLabirinto labirinto;
	
	private Partita vinta;
	private Partita persa;
	
	@BeforeEach
	
	public void SetUp() {
		
		this.labirinto = new LabirintoBuilder()
				
				.addStanzaIniziale("Atrio")
				.addStanza("N11")
				.getLabirinto();
		
		this.vinta = new Partita(this.labirinto, io);
		this.persa = new Partita(this.labirinto, io);
		
		this.vinta.setStanzaVincente(this.labirinto.getStanze().get("Atrio"));
		
		this.persa.setStanzaVincente(this.labirinto.getStanze().get("N11"));
		
	}
	
	

	@Test
	void testIsVintaVeramente() {
		
		assertTrue(this.vinta.vinta());
		
	}
	
	
	@Test
	void testIsVintaNonEvinta() {
		
		assertFalse(this.persa.vinta());
		
	}
	
	
	@Test
	void testIsFinitaVinta() {
		assertTrue(this.vinta.isFinita());
	}
	
	
	@Test
	void testIsFinitaXiCfu() {
		
		this.persa.getGiocatore().setCfuGioc(0);;
		assertTrue(this.persa.isFinita());
		
	}
	
	@Test
	void testIsFinita() {
		
		this.persa.setFinita();
		assertTrue(this.persa.isFinita());
		
	}
	
	

}

