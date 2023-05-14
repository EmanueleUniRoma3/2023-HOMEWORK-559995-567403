

package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comando.FabbricaDiComandi;
import it.uniroma3.diadia.comando.FabbricaDiComandoFisarmonica;
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
		processa = new FabbricaDiComandoFisarmonica();
		processa.setPartita(this.partita);
	}

	public void gioca() {
		String 	istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do		
			istruzione = io.leggiRiga(); 						
		while (processa.costruisci(istruzione) != null && !partita.isFinita());
	}

	public static void main(String[] argc) {

		IO io = new IOConsole();
		final Labirinto labirinto = new LabirintoBuilder()

				.addStanzaBloccata("atrio", "nord", "passepartout")
				.addStanza("aulaN11")
				.addStanza("aulaN10")
				.addStanzaBuia("laboratorio")
				.addStanzaFinale("biblioteca")
				.addAttrezzo("atrio","osso", 1)
				.addAttrezzo("aulaN10", "lanterna", 3)
				.addAttrezzo("laboratorio","passepartout", 2)
				.addAdiacenza("atrio", "biblioteca", "nord")
				.addAdiacenza("atrio", "aulaN10", "sud")
				.addAdiacenza("atrio", "aulaN11", "est")
				.addAdiacenza("atrio", "laboratorio", "ovest")
				.addAdiacenza("aulaN11", "laboratorio", "est")
				.addAdiacenza("aulaN11", "atrio", "ovest")
				.addAdiacenza("aulaN10", "atrio", "nord")
				.addAdiacenza("aulaN10", "aulaN11", "est")
				.addAdiacenza("aulaN10", "laboratorio", "ovest")
				.addAdiacenza("laboratorio", "atrio", "est")
				.addAdiacenza("laboratorio", "aulaN11", "ovest")
				.addAdiacenza("biblioteca", "atrio", "sud")
				.getLabirinto();
		
		labirinto.setStanzaIniziale(labirinto.getStanze().get("atrio"));

		DiaDia gioco = new DiaDia(labirinto ,io);
		gioco.gioca(); 


	}
}
