package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> attrezzi;
	public int numeroAttrezzi;
	private int pesoMax;
	public IO io;

	//over loading
	//jshell

	//costruttore secondario 
	public Borsa(IO io) {
		this(DEFAULT_PESO_MAX_BORSA, io);
	}


	//costruttore primario
	public Borsa(int pesoMax, IO io) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String,Attrezzo>(); // array di attrezzi in borsa
		this.numeroAttrezzi = 0;
		this.io = io;
	}
	
	public Map<String, Attrezzo> getMappaAttrezzi(){
		return this.attrezzi;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if((attrezzo.getPeso() + this.getPeso()) <= this.pesoMax)
			return this.attrezzi.put(attrezzo.getNome(), attrezzo) == null;//ho messo uguale a null perchè ggiungendolo la prima volta ritorna null

		return false;
	}


	public int getPesoMax() {
		return pesoMax;
	}



	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		a = this.attrezzi.get(nomeAttrezzo);
		return a;
	}


	public int getPeso() {
		int peso = 0;

		for(Attrezzo a : this.attrezzi.values()) {
			peso += a.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {

		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;

		if(this.attrezzi.containsKey(nomeAttrezzo)) 
			//rimuovo attrezzo e lo ritorno
			a = this.attrezzi.remove(nomeAttrezzo);

		else
			io.mostraMessaggio("Attrezzo non trovato in borsa! ");
		return a;
	}

	//STAMPA MAPPE {( ... )} ; {( ... )
	public String toString(Map<Integer, Set<Attrezzo>> mappaOrdinata) {

		if (!this.attrezzi.isEmpty()) {
			StringBuilder risultato = new StringBuilder();
			Set<Integer> insieme = mappaOrdinata.keySet();
			Iterator<Integer> iter = insieme.iterator();
			
			risultato.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			while(iter.hasNext()) {
			Integer chiave = iter.next();
			Set<Attrezzo> insiemeAttrezzi = mappaOrdinata.get(chiave);
			Iterator<Attrezzo> it = insiemeAttrezzi.iterator();
			
			risultato.append("(" + chiave + ", { " );//
			while(it.hasNext()) {
			Attrezzo a = it.next();
			risultato.append(a.getNome()+ " ");
			if(it.hasNext())
				risultato.append(", ");
			}
			risultato.append("} )");
			if(iter.hasNext())
				risultato.append(" ; ");
			}
			return risultato.toString();
		}
		return "Borsa vuota";
	}

	//STAMPA LE LISTE [ ....... ]
	public String toString(List<Attrezzo> lista) {
		
		if (!this.attrezzi.isEmpty()) {
			StringBuilder risultato = new StringBuilder();
			
			risultato.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): [ ");
			Iterator<Attrezzo> iter = lista.iterator();
			
			
			while(iter.hasNext()) {
				risultato.append(iter.next().getNome());
				if(iter.hasNext())
					risultato.append(", ");
			}
			risultato.append(" ]");
			
			return risultato.toString();

		}		
		
		return "Borsa vuota";
	}
	
	//STAMPA GLI INSIEMI { ..... }
	public String toString(SortedSet<Attrezzo> insieme) {

		if (!this.attrezzi.isEmpty()) {
			StringBuilder risultato = new StringBuilder();
			
			risultato.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): { ");
			
			Iterator<Attrezzo> iter = insieme.iterator();
			
			while(iter.hasNext()) {
				Attrezzo a = iter.next();
				risultato.append(a.getNome());
				if(iter.hasNext())
					risultato.append(", ");
			}
			risultato.append(" } ");
			
			return risultato.toString();
		}
		return "Borsa vuota";
	}		
  
	public String toString() {
		
		StringBuilder s = new StringBuilder();
				
				if (!this.attrezzi.isEmpty()) { //se non è vuota
		
					s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		
					for(Attrezzo a : this.attrezzi.values())
					s.append(a.getNome()+ " (" + a.getPeso()+"kg) " );
				}
				else 
					s.append("Borsa vuota");
				return s.toString();
		
	}
	


	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		//contenuto ordinato per peso		
		//ho la lista degli attrezzi
		List<Attrezzo> lista = new ArrayList<Attrezzo>(this.attrezzi.values());
		ComparatoreEsterno cmp = new ComparatoreEsterno();

		//devo ordinarla in base a un criterio: Esterno
		Collections.sort(lista, cmp);

		//ritorno la lista ordinata
		return lista;
	}
	
	
	public SortedSet<Attrezzo> getInsiemeOrdinatoPerPeso(){

		ComparatoreEsterno cmp = new ComparatoreEsterno();
		SortedSet<Attrezzo> insiemeAttrezzi = new TreeSet<Attrezzo>(cmp);

		insiemeAttrezzi.addAll(this.attrezzi.values()); //risultato.addAll(This.attrezzi.values());


		return insiemeAttrezzi;

	}
	
	

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){

		ComparatorePerNome cmp = new ComparatorePerNome();
		SortedSet<Attrezzo> insiemeAttrezzi = new TreeSet<Attrezzo>(cmp);

		insiemeAttrezzi.addAll(this.attrezzi.values()); //risultato.addAll(This.attrezzi.values());


		return insiemeAttrezzi;

	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){

		Map<Integer,Set<Attrezzo>> nuovaMappa = new HashMap<Integer, Set<Attrezzo>>();

		//mi itero la lista di attrezi che ho 
		for(Attrezzo a : this.attrezzi.values()) {
			//se la chiave è presente
			if(nuovaMappa.containsKey(a.getPeso())){
				nuovaMappa.get(a.getPeso()).add(a); //se la chiave peso è presente aggiungo solo l'attrezzo nell'insieme associato al peso
			}
			else {
				Set<Attrezzo> insieme = new HashSet<Attrezzo>();
				insieme.add(a);//aggiungo l'attrezzo
				//inserisco all'interno della mappa la coppia chiave-valore
				nuovaMappa.put(a.getPeso(), insieme);

			}

		}

		return nuovaMappa;
	}
}