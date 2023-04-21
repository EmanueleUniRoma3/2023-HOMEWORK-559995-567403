package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;

//	public ComandoPrendi(String nomeAttrezzo) {
//		this.nomeAttrezzo = nomeAttrezzo;
//	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		IO io = partita.getIO();

		Borsa borsa = partita.getGiocatore().getBorsa();

		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();

		//se ti passo un attrezzo allora cerco il suo indirizzo in attrezzi sta
		Attrezzo a = stanzaCorrente.getAttrezzo(nomeAttrezzo);

		//rimuovo l'attrezzo dalla stanza
		if (borsa != null && stanzaCorrente != null && a != null) {
			//verifica quanto pesa l'attrezzo
			//ho spostato il contatore del peso qui e anche quello del numero attrezzi massimo
			if (a.getPeso() + borsa.getPeso() <= borsa.getPesoMax() && borsa.numeroAttrezzi < borsa.attrezzi.length) {
				//non pesa troppo
				stanzaCorrente.removeAttrezzo(a);
				if(borsa.addAttrezzo(a))
					io.mostraMessaggio("Attrezzo aggiunto in borsa !!");
			}
			//ho aggiunto una stampa per dire che pesa troppo 
			else
				io.mostraMessaggio("Pesa troppo!! Se vuoi prenderlo posa un attrezzo!! Oppure hai troppi attrezzi!!!");

		}
		else
			io.mostraMessaggio("Non ho trovato l'attrezzo cercato!! ");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Prendi";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}



}


