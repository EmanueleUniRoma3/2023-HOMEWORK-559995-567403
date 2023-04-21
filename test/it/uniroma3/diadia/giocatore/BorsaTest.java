package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	Borsa borsaVuota;
	Borsa borsaSemiPiena;
	Borsa borsaPiena;
	
	//ATTREZZI
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
	private Attrezzo corona;
	private IO io = new IOConsole();
	
	@BeforeEach
	public void setUp() {
		
		borsaVuota = new Borsa(io);
		borsaSemiPiena = new Borsa(io);
		borsaPiena = new Borsa(io);
		
		martello = new Attrezzo("martello", 1);
		spada = new Attrezzo("spada", 1);
		cacciavite = new Attrezzo("cacciavite", 1);
		sciabola = new Attrezzo("sciabola", 7);
		torcia = new Attrezzo("torcia", 1);
		coltello = new Attrezzo("coltello", 1);
		arco = new Attrezzo("arco", 1);
		fucile = new Attrezzo("fucile", 1);
		corda = new Attrezzo("corda", 1);
		proiettile = new Attrezzo("proiettile", 1);
		freccia = new Attrezzo("freccia", 1);
		corona = new Attrezzo("corona", 1);
		
		borsaSemiPiena.addAttrezzo(martello);
		borsaSemiPiena.addAttrezzo(spada);
		borsaSemiPiena.addAttrezzo(cacciavite);
		borsaSemiPiena.addAttrezzo(torcia);
		borsaSemiPiena.addAttrezzo(coltello);
		
		borsaPiena.addAttrezzo(martello);
		borsaPiena.addAttrezzo(spada);
		borsaPiena.addAttrezzo(cacciavite);
		borsaPiena.addAttrezzo(torcia);
		borsaPiena.addAttrezzo(coltello);
		borsaPiena.addAttrezzo(arco);
		borsaPiena.addAttrezzo(fucile);
		borsaPiena.addAttrezzo(corda);
		borsaPiena.addAttrezzo(proiettile);
		borsaPiena.addAttrezzo(freccia);

	}
	
	@Test
	public void testAddAttrezzoBorsaVuota(){
		assertTrue(this.borsaVuota.addAttrezzo(arco));
	}
	
	@Test
	public void testAddAttrezzoBorsaSemiPiena(){
		assertTrue(this.borsaSemiPiena.addAttrezzo(arco));
	}
	
	@Test
	public void testAddAttrezzoBorsaPienaPerAttrezzi(){
		assertFalse(this.borsaPiena.addAttrezzo(corona));
	}
	
	@Test
	public void testAddAttrezzoBorsaPienaPerPeso(){
		assertFalse(this.borsaPiena.addAttrezzo(sciabola));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaVuota(){
		assertEquals(null ,this.borsaPiena.removeAttrezzo("sciabola"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaSemiPiena(){
		assertEquals(martello ,this.borsaPiena.removeAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaPiena(){
		assertEquals(coltello ,this.borsaPiena.removeAttrezzo("coltello"));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota(){
		assertFalse(this.borsaVuota.hasAttrezzo("arco"));
	}
	
	@Test
	public void testHasAttrezzoBorsaSemiPiena(){
		assertTrue(this.borsaSemiPiena.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaConAttrezzoDentro(){
		assertTrue(this.borsaPiena.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaSenzaAttrezzoDentro(){
		assertFalse(this.borsaPiena.hasAttrezzo("sciabola"));
	}
	
	@Test
	public void testGetPesoBorsaVuota(){
		assertEquals(0 ,this.borsaVuota.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaSemiPiena(){
		assertEquals(5 ,this.borsaSemiPiena.getPeso());
	}
	
	@Test
	public void testGetPesoBorsaPiena(){
		assertEquals(10 ,this.borsaPiena.getPeso());
	}
}
