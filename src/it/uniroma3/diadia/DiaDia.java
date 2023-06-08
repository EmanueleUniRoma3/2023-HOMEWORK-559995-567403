

package it.uniroma3.diadia;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.comando.FabbricaDiComandi;
import it.uniroma3.diadia.comando.FabbricaDiComandiRiflessiva;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {



	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	//static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private Labirinto labirinto;
	public static IO io;
	public FabbricaDiComandi processa;



	public DiaDia(Labirinto labirinto,IO IOConsole) {
		this.io = IOConsole;
		this.labirinto = labirinto;
		this.partita = new Partita(this.labirinto , IOConsole);
		processa = new FabbricaDiComandiRiflessiva();
		processa.setPartita(this.partita);
	}

	public void gioca() throws Exception {
		String 	istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do		
			istruzione = io.leggiRiga(); 						
		while (processa.costruisci(istruzione) != null && !partita.isFinita());
	}

	public static void main(String[] argc) throws Exception {

		IO io = new IOConsole();
		
		String nomeFile = io.leggiRiga();
		FileReader file = null;
		
		try {
		file = new FileReader(nomeFile);
		if(file.ready()) {
		final Labirinto labirinto = Labirinto.newBuilder(nomeFile)
									.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto ,io);
		gioco.gioca(); 
		}
		else
			System.out.println("Vuoto");
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File non trovato!! ");
		}
		finally {
			file.close();
		}


	}
}
