package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoNonValido extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		IO io = partita.getIO();
		
		io.mostraMessaggio("Comando non valido!! ");

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "ComandoNonValido";
	}


	@Override
	public String getMessaggio() {
		// TODO Auto-generated method stub
		return null;
	}
}
