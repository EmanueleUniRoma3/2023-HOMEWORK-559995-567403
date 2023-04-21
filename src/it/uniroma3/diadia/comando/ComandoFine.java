package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		IO io = partita.getIO();
		partita.setFinita();
		
		io.mostraMessaggio("Grazie per aver giocato!");  // si desidera smettere
		

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Fine";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
