

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
		this.partita = new Partita(IOConsole);
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

	
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	
	
//	private boolean processaIstruzione(String istruzione) {
//		Comando comandoDaEseguire = new Comando(istruzione);
//		if (comandoDaEseguire.getNome() != null) {
//			if (comandoDaEseguire.getNome().equals("fine")) {
//				this.fine(); 
//				return true;
//			} else if (comandoDaEseguire.getNome().equals("vai"))
//				this.vai(comandoDaEseguire.getParametro());
//			else if (comandoDaEseguire.getNome().equals("aiuto"))
//				this.aiuto();
//			else if (comandoDaEseguire.getNome().equals("prendi"))
//				this.prendi(comandoDaEseguire.getParametro());
//			else if  (comandoDaEseguire.getNome().equals("posa"))
//				this.posa(comandoDaEseguire.getParametro());
//			else
//				io.mostraMessaggio("Comando sconosciuto!!");
//			if (this.partita.vinta()) {
//				io.mostraMessaggio("Hai vinto!");
//				return true;
//			} else if (this.partita.isFinita()) {
//				io.mostraMessaggio("Hai perso!");
//				return true;
//			}
//			else
//				return false;
//		}  
//		return false;
//	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	
	
	
	
//	private void aiuto() {
//		for(int i=0; i< elencoComandi.length; i++) 
//			io.mostraMessaggio(elencoComandi[i]+" ");
//		io.mostraMessaggio("");
//	}

	
	
	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	
	
//	private void vai(String direzione) {
//		if(direzione==null)
//			stampa.mostraMessaggio("Dove vuoi andare ?");
//		Stanza prossimaStanza = null;
//		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
//		if (prossimaStanza == null)
//			stampa.mostraMessaggio("Direzione inesistente");
//		else {
//			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
//			int cfu = this.partita.getGiocatore().getCfuGioc();
//			partita.getGiocatore().setCfuGioc(--cfu);
//
//		}
//		stampa.mostraMessaggio("Cfu giocatore: "+ this.partita.getGiocatore().getCfuGioc());
//		stampa.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
//	}

	
	
	/**
	 * Comando "Fine".
	 */
	
//	private void fine() {
//		io.mostraMessaggio("Grazie per aver giocato!");  // si desidera smettere
//	}



//	private void prendi(String nomeAttrezzo) {
//
//		Borsa borsa = this.partita.getGiocatore().getBorsa();
//
//		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
//
//
//	//if (nomeAttrezzo != null) {
//			//se ti passo un attrezzo allora cerco il suo indirizzo in attrezzi sta
//			Attrezzo a = stanzaCorrente.getAttrezzo(nomeAttrezzo);
//
//			//rimuovo l'attrezzo dalla stanza
//			if (borsa != null && stanzaCorrente != null && a != null) {
//				//verifica quanto pesa l'attrezzo
//				//ho spostato il contatore del peso qui e anche quello del numero attrezzi massimo
//				if (a.getPeso() + borsa.getPeso() <= borsa.getPesoMax() && borsa.numeroAttrezzi < borsa.attrezzi.length) {
//					//non pesa troppo
//					stanzaCorrente.removeAttrezzo(a);
//					if(borsa.addAttrezzo(a))
//						stampa.mostraMessaggio("Attrezzo aggiunto in borsa !!");
//				}
//				//ho aggiunto una stampa per dire che pesa troppo 
//				else
//					stampa.mostraMessaggio("Pesa troppo!! Se vuoi prenderlo posa un attrezzo!! Oppure hai troppi attrezzi!!!");
//
//			}
//			else
//				stampa.mostraMessaggio("Non ho trovato l'attrezzo cercato!! ");
//		//}
//	}

//	private void posa(String nomeAttrezzo) {
//
//		//devo eliminare dalla borsa e posare nella stanza
//		Borsa borsa = this.partita.getGiocatore().getBorsa();
//
//		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
//
//		if (nomeAttrezzo != null) {
//
//			if (borsa != null && stanzaCorrente != null) {
//				Attrezzo att = borsa.removeAttrezzo(nomeAttrezzo);
//				if (att!= null) {
//					//devo aggiungere in stanza
//					stanzaCorrente.addAttrezzo(att);
//					//ora ho inserito in stanza corrente l'attrezzo
//					//System.out.println("Attrezzo aggiunto in stanza !!");
//					stampa.mostraMessaggio("Attrezzo aggiunto in stanza !!");
//				}
//			}
//		}
//
//	}

	public static void main(String[] argc) {
		
		IO io = new IOConsole();
		final Labirinto labirinto = new LabirintoBuilder()
		
		.addStanzaIniziale("atrio")
		.addStanza("aulaN11")
		.addStanzaBloccata("Atrio", "nord", "passepartout")
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
		
		DiaDia gioco = new DiaDia(labirinto ,io);
		gioco.gioca(); 
		
		
	}
}
