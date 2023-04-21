package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	private Attrezzo spada;
	private Attrezzo martello;
	private Attrezzo chiave;
	private Attrezzo chiodo;
	
	private Stanza atrio;
	private Attrezzo ossoi;
		
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.spada = new Attrezzo("spada", 2);
		this.martello = new Attrezzo("martello", 2);
		this.chiave = new Attrezzo("chiave", 2);
		this.chiodo = new Attrezzo("chiodo", 2);
		this.ossoi = new Attrezzo("ossoi", 2);
		atrio = new StanzaMagica("atrio");
		
	}

	@Test
	void testAddAttrezzoNonMagico() {
		atrio.addAttrezzo(spada);
		assertEquals(this.spada, atrio.getAttrezzo("spada"));
	}
	
	@Test
	void testAddAttrezzoMagico() {
		atrio.addAttrezzo(spada);
		atrio.addAttrezzo(martello);
		atrio.addAttrezzo(chiodo);
		atrio.addAttrezzo(chiave);
		assertTrue(atrio.hasAttrezzo("evaihc"));
		assertNotEquals(this.chiave, atrio.getAttrezzo("chiave"));
	}
	
	@Test
	void testPiùAttrezziMagici() {
		atrio.addAttrezzo(spada);
		atrio.addAttrezzo(martello);
		atrio.addAttrezzo(chiodo);
		atrio.addAttrezzo(chiave);
		atrio.addAttrezzo(ossoi);
		
		assertTrue(atrio.hasAttrezzo("spada"));
		assertTrue(atrio.hasAttrezzo("martello"));
		assertTrue(atrio.hasAttrezzo("chiodo"));
		assertTrue(atrio.hasAttrezzo("evaihc"));
		assertTrue(atrio.hasAttrezzo("iosso"));
		
		assertNotEquals(this.chiave, atrio.getAttrezzo("chiave"));
		assertNotEquals(this.ossoi, atrio.getAttrezzo("iosso"));

		
		
	}

}
