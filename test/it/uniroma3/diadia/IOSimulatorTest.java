package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {

	
	
	private IOSimulator ios;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		ios = new IOSimulator();
	}

	@Test
	void testUnSoloComando() {
		IOSimulator io = new IOSimulator("vai nord","Fine");
		assertEquals("Fine", new IOSimulator("Fine").leggiRiga());
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
