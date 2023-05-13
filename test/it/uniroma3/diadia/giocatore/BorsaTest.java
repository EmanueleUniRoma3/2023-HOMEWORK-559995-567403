package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

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
		assertTrue(this.borsaSemiPiena.hasAttrezzo("coltello"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaConAttrezzoDentro(){
		assertTrue(this.borsaPiena.hasAttrezzo("freccia"));
	}
	
	@Test
	public void testHasAttrezzoBorsaPienaSenzaAttrezzoDentro(){
		assertFalse(this.borsaPiena.hasAttrezzo("corona"));
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

	@Test
	public void testGetAttrezzoBorsaVuota(){
		assertEquals(null ,this.borsaVuota.getAttrezzo("arco"));
	}
	
	@Test
	public void testGetAttrezzoBorsa(){
		assertEquals(coltello ,this.borsaSemiPiena.getAttrezzo("coltello"));
	}
	
	@Test
	public void testGetContenutoOrdinatoSoloPerPeso() {
		
		Attrezzo martello = new Attrezzo("martello", 1);
		Attrezzo spada = new Attrezzo("spada", 2);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 3);
		Attrezzo torcia = new Attrezzo("torcia", 4);
		
		
		
		borsaVuota.addAttrezzo(torcia); //4
		borsaVuota.addAttrezzo(spada); //2
		borsaVuota.addAttrezzo(martello); //1
		borsaVuota.addAttrezzo(cacciavite);//3
		
		
		List<Attrezzo> lista = borsaVuota.getContenutoOrdinatoPerPeso();
		
		assertEquals(martello, lista.get(0));
		assertEquals(spada, lista.get(1));
		assertEquals(cacciavite, lista.get(2));
		assertEquals(torcia, lista.get(3));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeConPesoUguale() {
		
		Attrezzo martello = new Attrezzo("martello", 1);
		Attrezzo spada = new Attrezzo("spada", 1);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 1);
		Attrezzo sciabola = new Attrezzo("sciabola", 1);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(martello); 
		borsaVuota.addAttrezzo(cacciavite);
		
		
		List<Attrezzo> lista = borsaVuota.getContenutoOrdinatoPerPeso();
		
		assertEquals(martello, lista.get(1));
		assertEquals(sciabola, lista.get(2));
		assertEquals(spada, lista.get(3));
		assertEquals(cacciavite, lista.get(0));
		assertEquals(torcia, lista.get(4));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomePerPeso() {
		//ordino gli attrezzi principalmente per peso se sono uguali per nome
		Attrezzo martello = new Attrezzo("martello", 1); //get(0)
		Attrezzo spada = new Attrezzo("spada", 2); //get(2)
		Attrezzo cacciavite = new Attrezzo("cacciavite", 2); //get(1)
		Attrezzo sciabola = new Attrezzo("sciabola", 3); //get(4)
		Attrezzo torcia = new Attrezzo("torcia", 2); //get(3)
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(martello); 
		borsaVuota.addAttrezzo(cacciavite);
		
		
		List<Attrezzo> lista = borsaVuota.getContenutoOrdinatoPerPeso();
		
		assertEquals(martello, lista.get(0));
		assertEquals(sciabola, lista.get(4));
		assertEquals(spada, lista.get(2));
		assertEquals(cacciavite, lista.get(1));
		assertEquals(torcia, lista.get(3));
	}
	
	@Test 
	public void testGetContenutoOrdinatoPerNome() {
		
		Attrezzo martello = new Attrezzo("martello", 1);
		Attrezzo spada = new Attrezzo("spada", 1);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 1);
		Attrezzo sciabola = new Attrezzo("sciabola", 1);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(martello); 
		borsaVuota.addAttrezzo(cacciavite);
		
		
		SortedSet<Attrezzo> insiemeOrdinato = borsaVuota.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iter = insiemeOrdinato.iterator();
		
//		System.out.println("-------------------------------------------");
//		System.out.println(insiemeOrdinato);
//		System.out.println("-------------------------------------------");
		
		assertEquals(cacciavite, iter.next());
		assertEquals(martello, iter.next());
		assertEquals(sciabola, iter.next());
		assertEquals(spada, iter.next());
		assertEquals(torcia, iter.next());
		
	}
	
	@Test 
	public void testGetContenutoRaggruppatoPerPeso() {
		
		Attrezzo martello = new Attrezzo("martello", 1);
		Attrezzo spada = new Attrezzo("spada", 2);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 1);
		Attrezzo sciabola = new Attrezzo("sciabola", 2);
		Attrezzo torcia = new Attrezzo("torcia", 3);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(martello); 
		borsaVuota.addAttrezzo(cacciavite);
		
		Map<Integer, Set<Attrezzo>> mappa = borsaVuota.getContenutoRaggruppatoPerPeso();
		
		//System.out.println("-------------------------------------------");
		//System.out.println(mappa);
		//System.out.println("-------------------------------------------");

		Set<Attrezzo> insieme;
		assertTrue(mappa.containsKey(1));
		
		insieme = mappa.get(1);
		assertTrue(insieme.contains(cacciavite));
		assertTrue(insieme.contains(martello));
		assertTrue(insieme.size() == 2);
		
		
		assertTrue(mappa.containsKey(2));
		
		insieme = mappa.get(2);
		assertTrue(insieme.contains(sciabola));
		assertTrue(insieme.contains(spada));
		assertTrue(insieme.size() == 2);
		

		assertTrue(mappa.containsKey(3));
		
		insieme = mappa.get(3);
		assertTrue(insieme.contains(torcia));
		assertTrue(insieme.size() == 1);
	}
	
	
	@Test
	public void testGetInsiemeOrdinatoSiaPesoSiaNome() {

		Attrezzo spada = new Attrezzo("spada", 4);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 2);
		Attrezzo sciabola = new Attrezzo("sciabola", 2);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(cacciavite);
		
		
		SortedSet<Attrezzo> insiemeOrdinato = borsaVuota.getInsiemeOrdinatoPerPeso();
		Iterator<Attrezzo> iter = insiemeOrdinato.iterator();
		
		//System.out.println(insiemeOrdinato);
		
		assertEquals(torcia, iter.next());
		assertEquals(cacciavite, iter.next());
		assertEquals(sciabola, iter.next());
		assertEquals(spada, iter.next());
		
	}
	
	@Test
	public void testGetInsiemeOrdinatoPerPeso() {

		Attrezzo spada = new Attrezzo("spada", 4);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 3);
		Attrezzo sciabola = new Attrezzo("sciabola", 2);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(cacciavite);
		
		
		SortedSet<Attrezzo> insiemeOrdinato = borsaVuota.getInsiemeOrdinatoPerPeso();
		Iterator<Attrezzo> iter = insiemeOrdinato.iterator();
		
		//System.out.println(insiemeOrdinato);
		
		assertEquals(torcia, iter.next());
		assertEquals(sciabola, iter.next());
		assertEquals(cacciavite, iter.next());
		assertEquals(spada, iter.next());
		
	}	
	

	@Test
	public void testStampaListaOrdinataPerPesoToString() {
		
		Attrezzo spada = new Attrezzo("spada", 4);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 3);
		Attrezzo sciabola = new Attrezzo("sciabola", 2);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(cacciavite);
		
		List<Attrezzo> listaOrdinata = borsaVuota.getContenutoOrdinatoPerPeso();
		
		System.out.println(borsaVuota.toString(listaOrdinata));
		
		
	}
	
	
	@Test
	public void testStampaSortedSetOrdinataPerNomeToString() {
		
		Attrezzo spada = new Attrezzo("spada", 4);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 2);
		Attrezzo sciabola = new Attrezzo("sciabola", 2);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(cacciavite);
		
		SortedSet<Attrezzo> InsiemeOrdinato = borsaVuota.getContenutoOrdinatoPerNome();
		
		System.out.println(borsaVuota.toString(InsiemeOrdinato));
	}
	
	@Test
	public void testStampaMappaOrdinataPerPesoToString() {
		
		Attrezzo spada = new Attrezzo("spada", 4);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 2);
		Attrezzo sciabola = new Attrezzo("sciabola", 2);
		Attrezzo torcia = new Attrezzo("torcia", 1);
		
		borsaVuota.addAttrezzo(torcia); 
		borsaVuota.addAttrezzo(sciabola); 
		borsaVuota.addAttrezzo(spada); 
		borsaVuota.addAttrezzo(cacciavite);
		
		Map<Integer,Set<Attrezzo>> MappaOrdinata = borsaVuota.getContenutoRaggruppatoPerPeso();
		
		System.out.println(borsaVuota.toString(MappaOrdinata));
	}
	
	
	
}
