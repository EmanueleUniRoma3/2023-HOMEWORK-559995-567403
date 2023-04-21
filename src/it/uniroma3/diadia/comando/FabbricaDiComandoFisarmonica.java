package it.uniroma3.diadia.comando;

import java.util.Scanner;

import it.uniroma3.diadia.Partita;

public class FabbricaDiComandoFisarmonica implements FabbricaDiComandi {
	
	private Partita partita;
	
	@Override
	public Comando costruisci(String istruzione) {



		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro

		if (nomeComando == null) 
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else comando = new ComandoNonValido();
		
		comando.setParametro(parametro);
		comando.esegui(this.partita);

		return comando;
	}

	@Override
	public void setPartita(Partita partita) {
		// TODO Auto-generated method stub
		this.partita = partita;
		
	}

}
