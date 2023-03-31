package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	//over loading 

	//costruttore secondario 
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);

	}


	//costruttore primario
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (attrezzo != null) {
			if (this.numeroAttrezzi==10)
				//Ho troppi attrezzi
				return false;
			//fa parte del giocatore
			//devo guardare nella borsa la lista degli attrezzi
			else {
				int i = 0; 
				while (this.attrezzi[i] != null) {
					i++;
				}

				this.attrezzi[i] = attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
		}
		return false;
	}


	public int getPesoMax() {
		return pesoMax;
	}



	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<attrezzi.length; i++) {
			if (this.attrezzi[i] != null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					a = attrezzi[i];
					return a;
				}
			}
		}
		return a;
	}


	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.length; i++)
			if (attrezzi[i] != null) 
				peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		int i=0;

		// ---> TODO (implementare questo metodo) <---
		if (isEmpty()) {
			System.out.println("La borsa è vuota!!!");
		}	
		else {
			a = getAttrezzo(nomeAttrezzo); //mi salvo il riferimento dell'attrezzo qui 
			//ora devo rimuovere l'attrezzo dalla borsa
			if (a != null) {
				//io devo entrare nel while sia quando è null sia quando non è uguale
				while(attrezzi[i] == null || !attrezzi[i].getNome().equals(a.getNome())) {
					i++;
				}
				this.attrezzi[i] = null;
				this.numeroAttrezzi--;

			}
			else 
				System.out.println("L'attrezzo non c'è!!");
		}

		return a;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else 
			s.append("Borsa vuota");
		return s.toString();
	}
}