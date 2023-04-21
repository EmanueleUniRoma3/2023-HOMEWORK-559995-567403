package it.uniroma3.diadia.comando;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.giocatore.Giocatore;

class ComandoPosaTest {


	private ComandoPosa comandoPosa;
	private Partita partita;
	private IO io;
	private Stanza N11;
	private Attrezzo attrezzo;





	@BeforeEach
	void setUp() throws Exception {
		
		this.comandoPosa = new ComandoPosa();
		this.io = new IOConsole();
		this.partita = new Partita(io);
		this.attrezzo = new Attrezzo("Spada", 2);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
	
	}

	@Test
	void testEseguiComandoPosa() {
		
		comandoPosa.setParametro("Spada");
		comandoPosa.esegui(this.partita);
		
		
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("Spada"));
		assertEquals("Atrio",this.partita.getLabirinto().getStanzaCorrente().getNome());
	}

}
