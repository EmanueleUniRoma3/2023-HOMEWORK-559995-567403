package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	final static private int SOGLIA_MAGICA_DEFAULT = 3;


	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;


	}
	
	

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++;
		
		 if (this.contatoreAttrezziPosati > this.sogliaMagica) 
		 attrezzo = this.modificaAttrezzo(attrezzo);
				//ne ho di meno, allora se attrezzo != null
				if (attrezzo != null) {
					int i = 0;

					while (this.attrezzi[i] != null) { 
						i++;
					}
					this.attrezzi[i] = attrezzo;
					this.numeroAttrezzi++;
					return true;

				}

			
			//altrimenti ho troppi attrezzi
			return false;
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
