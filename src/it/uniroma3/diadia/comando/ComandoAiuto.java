package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoAiuto extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "regala", "interagisci"};

		IO io = partita.getIO();

		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Aiuto";
	}


	@Override
	public String getMessaggio() {
		// TODO Auto-generated method stub
		return null;
	}

}
