package it.uniroma3.diadia.comando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.ambienti.Stanza;

import it.uniroma3.diadia.*;

class ComandoVaiTest {

private ComandoVai comando;

private Partita partita;

private IOConsole IOConsole;

private Stanza N11;

private Stanza AulaCampus;


@BeforeEach


public void setUp() {

this.comando = new ComandoVai();

this.IOConsole = new IOConsole();

this.partita = new Partita(IOConsole);

this.N11 = new Stanza("N11");

this.partita.getLabirinto().setStanzaCorrente(N11);

this.AulaCampus = new Stanza("AulaCampus");

this.N11.impostaStanzaAdiacente("sud", AulaCampus);

}


@Test

void testEseguiComandoVai() {

assertEquals(N11, this.partita.getLabirinto().getStanzaCorrente());

this.comando.setParametro("sud");

this.comando.esegui(this.partita);

assertEquals(this.AulaCampus, this.partita.getLabirinto().getStanzaCorrente());

}

}
