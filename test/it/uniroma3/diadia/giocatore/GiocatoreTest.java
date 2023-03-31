package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;


class GiocatoreTest {
	
	private Giocatore giocatore = new Giocatore();
	private Giocatore giocatore0cfu = new Giocatore();
	
	@BeforeEach 
	
	
	public void setUp() {
		
		this.giocatore.setCfuGioc(20);
		this.giocatore0cfu.setCfuGioc(0);
	}
	
	
	

	@Test
	void testGetCfu() {
		assertEquals(20, this.giocatore.getCfuGioc());
	}
	
	
	@Test
	void testGet0Cfu() {
		assertEquals(0, this.giocatore0cfu.getCfuGioc());
	}
	
	


}

