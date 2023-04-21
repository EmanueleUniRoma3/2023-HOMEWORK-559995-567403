package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};

		IO io = partita.getIO();

		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub	
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Aiuto";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
