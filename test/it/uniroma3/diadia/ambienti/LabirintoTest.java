package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza biblioteca;
	private Stanza atrio;
	
	
	@BeforeEach
	public void setUp(){
		labirinto = new Labirinto();
		biblioteca = new Stanza("Biblioteca");
		atrio = new Stanza("Atrio");
	}
	
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals(atrio.getNome(), labirinto.getStanzaIniziale().getNome());	
	}
	
	@Test
	public void testGetUscita() {
		assertEquals(biblioteca.getNome(), labirinto.getUscita().getNome());
	}
	
	
}
