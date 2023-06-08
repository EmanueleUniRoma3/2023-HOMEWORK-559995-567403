package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoFine extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		IO io = partita.getIO();
		partita.setFinita();
		
		io.mostraMessaggio("Grazie per aver giocato!");  // si desidera smettere
		

	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Fine";
	}

	@Override
	public String getMessaggio() {
		// TODO Auto-generated method stub
		return null;
	}
}
