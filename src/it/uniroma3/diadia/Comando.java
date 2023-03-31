package it.uniroma3.diadia;



import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

	private String nome;
	private String parametro;

	public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione); //scandisce le parole dentro una riga, come "vai sud ", 
		//scandisce vai e poi sud che sono il primo un comando e il secondo un parametro
		//guarda le due if sotto!!
		// prima parola: nome del comando
		if (scannerDiParole.hasNext()) //scannerDiParole(has.Next) mi da un booleano, se mi da vero vuol dire che ho qualcos altro da vedere
			this.nome = scannerDiParole.next();  //qui salvo il comando: "vai"

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();//qui salvo il parametro "sud"
	}

	public String getNome() {
		return this.nome;
	}


	public String getParametro() {
		return this.parametro;
	}

	public boolean sconosciuto() {
		return (this.nome == null);
	}
}