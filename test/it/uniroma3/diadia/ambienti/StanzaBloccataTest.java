package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

private Attrezzo passepartout;

private Stanza adiacente;

private StanzaBloccata corrente;

private Attrezzo spada;



@BeforeEach

public void setUp() {

this.passepartout = new Attrezzo("corona", 7);

this.spada = new Attrezzo("spada", 3);

this.corrente = new StanzaBloccata("adiacente", "sud", "corona");

this.corrente.addAttrezzo(spada);

this.adiacente = new Stanza("N10");

}


@Test

void testGetStanzaAdiacente() {

this.corrente.addAttrezzo(passepartout);

this.corrente.impostaStanzaAdiacente("sud", adiacente);

assertEquals(this.adiacente, this.corrente.getStanzaAdiacente("sud"));

}


@Test

void testGetStanzaAdiacenteQuandoNonHaiPassepartout() {

this.corrente.addAttrezzo(spada);

this.corrente.impostaStanzaAdiacente("sud", adiacente);

assertEquals(this.corrente, this.corrente.getStanzaAdiacente("sud"));

}


@Test

void getDescrizioneSeNonMiMuovo() {

this.corrente.addAttrezzo(spada);

this.corrente.impostaStanzaAdiacente("sud", adiacente);

assertEquals(this.corrente.getDescrizione(), this.corrente.getDescrizione());

}



@Test

void testTrovaPassepartout() {

this.corrente.addAttrezzo(passepartout);

assertTrue(this.corrente.trovaPassepartout());

}

}