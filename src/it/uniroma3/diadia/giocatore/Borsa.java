package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Una semplice classe che modella una Borsa.
 * La Borsa del giocatore può contenere degli attrezzi prelevati
 * dallo stesso giocatore all'interno della stanze del labirinto.
 *
 * @author  docente di POO
 * @see Attrezzo
 * @version base
 */
public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	/*costruttore dell'oggetto borsa, riceve come parametro un valore intero*/
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	/*metodo che verifica se all'interno della borsa è possibile aggiungere un'attrezzo con un determinato peso,
	 * riceve come parametro l'attrezzo un attrezzo.
	 * Restituisce un valore booleano true se è possibile, false altrimenti*/
	public boolean addIsPossible(Attrezzo attrezzo) {
		return (this.getPeso()+attrezzo.getPeso()<= this.getPesoMax()) && this.numeroAttrezzi<10;
	}

	/*metodo che aggiunge un'attrezzo nella borsa del giocatore, restituisce un booleano.
	 * restituisce true se l'attrezzo è stato aggiunto, false altrimenti*/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.addIsPossible(attrezzo)) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else
			return false;
	}

	/*restituisce il peso massimo della borsa come valore intero*/
	public int getPesoMax() {
		return this.pesoMax;
	}

	/*accerta la presenza di un attrezzo all'interno della borsa restituendolo (uguaglianza con il nome)*/
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}

	/*calcola il peso contenuto all'interno della borsa,
	 * restituisce il valore intero pari al peso di tutti gli attrezzi contenuti*/
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}

	/* metodo che calcola se la borsa è vuota, restituisce un booleano
	 * restituisce true se la borsa è vuota, flase altrimenti*/

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	/*metodo che che cerca l'esistenza di un attrezzo all'interno della borsa
	 * restituisce un booleano, true se l'attrezzo è presente, false altrimenti*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/*metodo che rimuove un'attrezzo dalla borsa del giocatore (uguagliana per nome).
	 * restituisce l'attrezzo eliminato*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		boolean eliminato = false;
		if(!this.isEmpty()) {
			for(int i = 0; i < this.numeroAttrezzi; i++) {
				if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
					a = attrezzi[i];  // attrezzo da rimuovere
					// elimino l'attrezzo dalla borsa del giocatore
					for(int j = i; j < this.numeroAttrezzi-1; j++) {
						attrezzi[j] = attrezzi[j+1];
					}
					attrezzi[this.numeroAttrezzi-1] = null;
					this.numeroAttrezzi--;
					eliminato = true;
				}
			}
		}
		// restituisco l'attrezzo eliminato
		if(eliminato) 
			return a;		
		else 		
			return a;		
	}

	/**
	 * Restituisce una rappresentazione stringa della borsa,
	 * stampadone gli eventuali attrezzi contenuti nel caso non fosse vuota
	 * @return la rappresentazione stringa
	 */
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


	/**
	 * Restituisce la descrizione della borsa.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

}