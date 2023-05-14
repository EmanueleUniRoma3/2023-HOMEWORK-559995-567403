package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {



	private IOSimulator ios;
	private List<String> listaDaLeggere;


	@BeforeEach
	void setUp() throws Exception {

		listaDaLeggere = new ArrayList<>();

		ios = new IOSimulator(listaDaLeggere);
	}

	@Test
	void testUnSoloComando() {
		listaDaLeggere.add("vai nord");
		ios.mostraMessaggio("Fine");
		assertEquals("vai nord",ios.leggiRiga());
		assertEquals("Fine",ios.leggiRiga());
	}

	@Test
	void testDueComandi() {
		IOSimulator io = new IOSimulator("vai nord","Fine");
		assertEquals("vai nord", io.leggiRiga());
		assertEquals("Fine", io.leggiRiga());
	}

	@Test
	void testComando() {
		assertNull(new IOSimulator().leggiRiga());
	}

	@Test
	void testTroppeLetture() {
		IOSimulator io = new IOSimulator("Fine");
		assertEquals("Fine", io.leggiRiga());
		io.leggiRiga();
	}

}
