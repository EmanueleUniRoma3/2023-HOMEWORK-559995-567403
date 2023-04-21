package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	final static int SOGLIA_MAGICA_DEFAULT = 3;


	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (this.contatoreAttrezziPosati > this.sogliaMagica) 
			attrezzo = this.modificaAttrezzo(attrezzo);
		this.contatoreAttrezziPosati++;
		return super.addAttrezzo(attrezzo);			
	}
	
	//nuovo metodo di stanza magica
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {

		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);

		return attrezzo;

	}
	
	
	



}
