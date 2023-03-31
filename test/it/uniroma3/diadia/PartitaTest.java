package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;

import org.junit.jupiter.api.BeforeEach;


class PartitaTest {
	
	private Partita vinta = new Partita();
	private Partita persa = new Partita();
	private Stanza atrio = new Stanza("atrio");
	private Stanza N11 = new Stanza("N11");
	
	@BeforeEach
	
	public void SetUp() {
		
		this.vinta.getLabirinto().setStanzaCorrente(atrio);
		this.vinta.getLabirinto().setUscita(atrio);
		
		
		this.persa.getLabirinto().setStanzaCorrente(atrio);
		this.persa.getLabirinto().setUscita(N11);
		
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

