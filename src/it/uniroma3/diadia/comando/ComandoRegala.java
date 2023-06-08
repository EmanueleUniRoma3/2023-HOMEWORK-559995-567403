package it.uniroma3.diadia.comando;

import java.util.Map;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {


	/**
	 * Il giocatore può regalare un attrezo al personaggio presente nella stanza	
	 */
	@Override
	public void esegui(Partita partita) {

		IO io = new IOConsole();
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = partita.getGiocatore().getPosizione();
		AbstractPersonaggio personaggioCorrente = stanzaCorrente.getPersonaggio();

		Map<String, Attrezzo> listaAttrezzi = borsa.getMappaAttrezzi();
		String attrezzoCercato = this.getParametro();


		if(!listaAttrezzi.containsKey(attrezzoCercato)) {
			io.mostraMessaggio("Mi spiace non hai questo attrezzo! ");
			//mostro gli attrezzi presenti nella borsa
			StringBuilder stringa = new StringBuilder();
			for(String s : listaAttrezzi.keySet()) {
				stringa.append(""+ s +"");
			}//alla fine stampa la lista
			stringa.toString();
		}

		if(personaggioCorrente == null) {
			io.mostraMessaggio("Mi spiace non è presente nessun Personaggio! ");
		}
		else {
			for(String s : listaAttrezzi.keySet()) {

				//se ho l'attrezzo in borsa 
				if(s.equals(attrezzoCercato)) {
					//regalo il mio attrezzo
					personaggioCorrente.riceviRegalo(listaAttrezzi.get(s), partita);
					//lo elimino dalla borsa
					borsa.removeAttrezzo(s);
				}
			}
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Regala";
	}


	@Override
	public String getMessaggio() {
		// TODO Auto-generated method stub
		return null;
	}

}
