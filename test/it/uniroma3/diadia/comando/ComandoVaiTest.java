package it.uniroma3.diadia.comando;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {

private ComandoVai comando;

private Partita partita;

private IOConsole IOConsole;

private Labirinto labirinto;




@BeforeEach


public void setUp() {

this.comando = new ComandoVai();

this.IOConsole = new IOConsole();

this.labirinto = new LabirintoBuilder()
	.addStanzaIniziale("N11")
	.addStanza("Aula Campus")
	.addStanza("Aula N10")
	.addAdiacenza("N11", "Aula N10", "nord")
	.addAdiacenza("N11", "Aula Campus", "sud")
	.getLabirinto();
	

this.partita = new Partita(this.labirinto ,IOConsole);

}


@Test

void testEseguiComandoVai() {

assertEquals(this.labirinto.getStanze().get("N11"), this.partita.getGiocatore().getPosizione());

this.comando.setParametro("nord");

this.comando.esegui(this.partita);

assertEquals(this.labirinto.getStanze().get("Aula N10"), this.partita.getGiocatore().getPosizione());

}

}
