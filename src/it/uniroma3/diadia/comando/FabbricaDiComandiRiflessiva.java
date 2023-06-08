package it.uniroma3.diadia.comando;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	private Partita partita;
	private IO io = new IOConsole();

	@Override
	public AbstractComando costruisci(String istruzione) throws Exception {



		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		
		try {
			//		Costruisco il nome della classe a partire dal nome del comando contenuto in nomeComando
			String nomeClasse = new String("it.uniroma3.diadia.comando.Comando");

			//		gli fornisco la prima lettera del comando 
			//		es nomeClasse: "it.uniroma3.diadia.comando.ComandoV"
			nomeClasse += Character.toUpperCase(nomeComando.charAt(0));

			//		Perchè non scrivere direttamente questo ???
			nomeClasse += nomeComando.substring(1);

			//		Qua gli do il nome della classe e attraverso questa creo una new Istance().
			comando = (AbstractComando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();
			comando.setParametro(parametro);
			comando.esegui(this.partita);

		}

		catch(Exception e){
			comando = new ComandoNonValido();
			io.mostraMessaggio("Comando Sconosciuto");
		}

		return comando;
	}
	
	@Override
	public void setPartita(Partita partita) {
		// TODO Auto-generated method stub
		this.partita = partita;
	}

}
