package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;

class StanzaTest {		
	

	//STANZE E ATTREZZI
	private Stanza stanzaVuota;
	private Stanza semiPiena;
	private Stanza stanzaPiena;
	
	//ATTREZZI PER LA STANZA
	private Attrezzo martello;
	private Attrezzo spada;
	private Attrezzo cacciavite; 
	private Attrezzo sciabola;
	private Attrezzo torcia;
	private Attrezzo coltello;
	private Attrezzo arco;
	private Attrezzo fucile;
	private Attrezzo corda;
	private Attrezzo proiettile;
	private Attrezzo freccia;
	
	
	@BeforeEach
	public void setUp2() {
		
		stanzaVuota = new Stanza("Vuota");
		semiPiena = new Stanza("Piena");
		stanzaPiena = new Stanza("SemiPiena");
		
		martello = new Attrezzo("martello", 4);
		spada = new Attrezzo("spada", 7);
		cacciavite = new Attrezzo("cacciavite", 3);
		sciabola = new Attrezzo("sciabola", 6);
		torcia = new Attrezzo("torcia", 2);
		coltello = new Attrezzo("coltello", 1);
		arco = new Attrezzo("arco", 4);
		fucile = new Attrezzo("fucile", 5);
		corda = new Attrezzo("corda", 2);
		proiettile = new Attrezzo("proiettile", 1);
		freccia = new Attrezzo("freccia", 1);
 		
		
		semiPiena.addAttrezzo(martello);
		semiPiena.addAttrezzo(spada);
		semiPiena.addAttrezzo(cacciavite);
		semiPiena.addAttrezzo(sciabola);
		semiPiena.addAttrezzo(torcia);
		
		stanzaPiena.addAttrezzo(martello);
		stanzaPiena.addAttrezzo(spada);
		stanzaPiena.addAttrezzo(cacciavite);
		stanzaPiena.addAttrezzo(sciabola);
		stanzaPiena.addAttrezzo(torcia);
		stanzaPiena.addAttrezzo(coltello);
		stanzaPiena.addAttrezzo(arco);
		stanzaPiena.addAttrezzo(fucile);
		stanzaPiena.addAttrezzo(corda);
		stanzaPiena.addAttrezzo(proiettile);
		
		
		
	}
	
	@Test
	public void testAddAttrezzoStanzaVuota() {
		assertTrue(this.stanzaVuota.addAttrezzo(martello));
	}	
	
	@Test
    public void testAddAttrezzoStanzaSemiPiena() {
		assertTrue(this.semiPiena.addAttrezzo(freccia));
    }
	
//	@Test
//    public void testAddAttrezzoStanzaPiena() {
//		assertFalse(this.stanzaPiena.addAttrezzo(freccia));
//	}
	
	@Test
	public void testRemoveAttrezzoStanzaVuota() {
		assertFalse(this.stanzaVuota.removeAttrezzo(arco));
	}
	
	@Test
	public void testRemoveAttrezzoSemiPiena() {
		assertTrue(this.semiPiena.removeAttrezzo(martello));
	}
	
	@Test
    public void testRemoveAttrezzoStanzaPiena() {
		assertTrue(this.stanzaPiena.removeAttrezzo(arco));
	}
	
	@Test
	public void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanzaVuota.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzoSemiPiena() {
		assertTrue(this.semiPiena.hasAttrezzo("martello"));
	}
	
	@Test
    public void testHasAttrezzoStanzaPiena() {
		assertTrue(this.stanzaPiena.hasAttrezzo("martello"));
	}
	
	@Test
	public void testGetAttrezzoStanzaVuota() {
		assertEquals(null,this.stanzaVuota.getAttrezzo("martello"));
	}
	
	@Test
	public void testGetAttrezzoSemiPiena() {
		assertEquals(martello,this.semiPiena.getAttrezzo("martello"));
	}
	
	@Test
    public void testGetAttrezzoStanzaPiena() {
		assertEquals(martello,this.stanzaPiena.getAttrezzo("martello"));
	}
	
	
}
