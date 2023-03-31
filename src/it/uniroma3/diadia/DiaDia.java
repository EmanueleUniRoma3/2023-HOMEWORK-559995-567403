

package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;

import java.util.Scanner;

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

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private IOConsole stampa;
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
		this.stampa  = new IOConsole();
	}

	public void gioca() {
		String 	istruzione; 
		Scanner scannerDiLinee; //scansione delle righe, scannerizza le parole presenti dentro la riga 

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome() != null) {
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if  (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else
				System.out.println("Comando sconosciuto");
			if (this.partita.vinta()) {
				System.out.println("Hai vinto!");
				return true;
			} else if (this.partita.isFinita()) {
				System.out.println("Hai perso!");
				return true;
			}
			else
				return false;
		}  
		return false;
	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfuGioc();
			partita.getGiocatore().setCfuGioc(--cfu);

		}
		System.out.println("Cfu giocatore: "+ this.partita.getGiocatore().getCfuGioc());
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}



	private void prendi(String nomeAttrezzo) {

		Borsa borsa = this.partita.getGiocatore().getBorsa();

		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();


		if (nomeAttrezzo != null) {
			//se ti passo un attrezzo allora cerco il suo indirizzo in attrezzi sta
			Attrezzo a = stanzaCorrente.getAttrezzo(nomeAttrezzo);

			//rimuovo l'attrezzo dalla stanza
			if (borsa != null && stanzaCorrente != null && a != null) {
				//verifica quanto pesa l'attrezzo
				//ho spostato il contatore del peso qui
				if (a.getPeso() + borsa.getPeso() < borsa.getPesoMax()) {
					//non pesa troppo
					stanzaCorrente.removeAttrezzo(a);
					if(borsa.addAttrezzo(a))
						System.out.println("Attrezzo aggiunto in borsa !!");
				}
				//ho aggiunto una stampa per dire che pesa troppo 
				else
					System.out.println("Pesa troppo!! Se vuoi prenderlo posa un attrezzo!! ");

			}
			else
				System.out.println("Non ho trovato l'attrezzo cercato!! ");
		}
	}

	private void posa(String nomeAttrezzo) {

		//devo eliminare dalla borsa e posare nella stanza
		Borsa borsa = this.partita.getGiocatore().getBorsa();

		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();

		if (nomeAttrezzo != null) {

			if (borsa != null && stanzaCorrente != null) {
				Attrezzo att = borsa.removeAttrezzo(nomeAttrezzo);
				if (att!= null) {
					//devo aggiungere in stanza
					stanzaCorrente.addAttrezzo(att);
					//ora ho inserito in stanza corrente l'attrezzo
					//System.out.println("Attrezzo aggiunto in stanza !!");
					stampa.mostraMessaggio("Attrezzo aggiunto in stanza !!");
				}
			}
		}

	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca(); 
	}
}
