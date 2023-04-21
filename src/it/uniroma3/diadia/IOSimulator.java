package it.uniroma3.diadia;

public class IOSimulator implements IO {

	
	String comandiLetti[];
	private int indiceProxComando;
	
	
	
	public IOSimulator(String...comandiLetti) {
		this.comandiLetti = comandiLetti;
		this.indiceProxComando = 0;
	}

	@Override
	public void mostraMessaggio(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String leggiRiga() {
		if (this.comandiLetti.length == 0)
			return null;
		else
		return this.comandiLetti[this.indiceProxComando++];
	}

}
