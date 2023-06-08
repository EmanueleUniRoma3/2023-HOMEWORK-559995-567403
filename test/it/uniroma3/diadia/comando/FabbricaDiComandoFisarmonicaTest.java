package it.uniroma3.diadia.comando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandoFisarmonicaTest {

	ComandoAiuto comandoAiuto;
	ComandoFine comandoFine;
	ComandoGuarda comandoGuarda;
	ComandoNonValido comandoNonValido;
	ComandoPosa comandoPosa;
	ComandoPrendi comandoPrendi;
	ComandoVai comandoVai;
	FabbricaDiComandi fabbrica;


	@BeforeEach
	void setUp() throws Exception {

		comandoAiuto = new ComandoAiuto();
		comandoFine = new ComandoFine();
		comandoGuarda = new ComandoGuarda();
		comandoNonValido = new ComandoNonValido();
		comandoPosa = new ComandoPosa();
		comandoPrendi = new ComandoPrendi();
		comandoVai = new ComandoVai();
		fabbrica = new FabbricaDiComandiRiflessiva();
	}

	@Test
	void testCostruisciComandoAiuto() {
		assertEquals("Aiuto",comandoAiuto.getNome());		
	}
	

	@Test
	void testCostruisciComandoAiutoSbagliato() {
		assertNotEquals("ComandoAiu",comandoAiuto.getNome());		
	}

	@Test
	void testCostruisciComandoFine() {
		assertEquals("Fine",comandoFine.getNome());		
	}

	@Test
	void testCostruisciComandoFineSbagliato() {
		assertNotEquals("ComandoFina",comandoFine.getNome());		
	}

	@Test
	void testCostruisciComandoGuarda() {
		assertEquals("Guarda",comandoGuarda.getNome());		
	}

	@Test
	void testCostruisciComandoGuardaSbagliato() {
		assertNotEquals("ComandoGuards",comandoGuarda.getNome());		
	}


	@Test
	void testCostruisciComandoNonValido() {
		assertEquals("ComandoNonValido",comandoNonValido.getNome());		
	}

	@Test
	void testCostruisciComandoNonValidoSbagliato() {
		assertNotEquals("ComandoNonValidi",comandoNonValido.getNome());		
	}


	@Test
	void testCostruisciComandoPosa() {
		assertEquals("Posa",comandoPosa.getNome());		
		comandoPosa.setParametro("Attrezzo");
		assertEquals("Attrezzo", comandoPosa.getParametro());
	}

	@Test
	void testCostruisciComandoPosaSbagliato() {
		assertNotEquals("ComandoPosi",comandoPosa.getNome());		
		comandoPosa.setParametro("Attrezzo");
		assertNotEquals("Attrezzi", comandoPosa.getParametro());
	}

	@Test
	void testCostruisciComandoPrendi() {
		assertEquals("Prendi",comandoPrendi.getNome());	
		comandoPrendi.setParametro("Attrezzo");
		assertEquals("Attrezzo", comandoPrendi.getParametro());
	}

	@Test
	void testCostruisciComandoPrendiSbagliato() {
		assertNotEquals("ComandoPrendo",comandoPrendi.getNome());	
		comandoPrendi.setParametro("Attrezzo");
		assertNotEquals("Attrezzi", comandoPrendi.getParametro());
	}

	@Test
	void testCostruisciComandoVai() {
		assertEquals("Vai",comandoVai.getNome());
		comandoVai.setParametro("sud");
		assertEquals("sud", comandoVai.getParametro());
	}

	@Test
	void testCostruisciComandoVaiSbagliato() {
		assertNotEquals("ComandoVae",comandoVai.getNome());
		comandoVai.setParametro("sud");
		assertNotEquals("suf", comandoVai.getParametro());
	}

}
