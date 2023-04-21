package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	Stanza N11; //stanza con attrezzo lanterna
	Stanza N12; //stanza senza attrezzo lanterna
	Attrezzo lanterna;
	Attrezzo spada;


	@BeforeEach
	void setUp() throws Exception {
		
		N11 = new StanzaBuia("N11"); //stanza con attrezzo lanterna
		N12 = new StanzaBuia("N12"); //stanza senza attrezzo lanterna
		lanterna = new Attrezzo("lanterna", 2); 
		spada = new Attrezzo("spada", 1);
		
		N11.addAttrezzo(lanterna);
		N12.addAttrezzo(spada);
	}

	@Test
	void getDescrizioneStanzaConLanterna() {
		assertEquals(N11.toString(), N11.getDescrizione());
	}
	
	@Test
	void getDescrizioneBuia() {
		assertEquals("Qui c'è buio pesto, ti serve la lanterna.", N12.getDescrizione());
	}

}
