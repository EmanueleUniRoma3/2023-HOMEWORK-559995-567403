package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {
	
	private Labirinto labirinto;
	
	
	@BeforeEach
	public void setUp(){
		labirinto = new LabirintoBuilder()
				.addStanzaFinale("Biblioteca")
				.addStanzaIniziale("Atrio")
				.getLabirinto();
	}
	
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals(labirinto.getStanze().get("Atrio"), labirinto.getStanzaIniziale());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaIniziale(labirinto.getStanze().get("Biblioteca"));
		assertEquals(labirinto.getStanze().get("Biblioteca"), labirinto.getUscita());
	}
	
	
	@Test
	public void testGetUscita() {
		assertEquals(labirinto.getStanze().get("Biblioteca"), labirinto.getUscita());
	}
	
	@Test
	public void testSetUscita() {
		labirinto.setUscita(labirinto.getStanze().get("Atrio"));
		assertEquals(labirinto.getStanze().get("Atrio"), labirinto.getUscita());
	}
	
	
}
