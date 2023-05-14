package it.uniroma3.diadia.giocatore;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezzoPerPeso;

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
	private HashMap<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	// costruttore Borsa no args 
	public Borsa() {
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
	}

	/*costruttore dell'oggetto borsa, riceve come parametro un valore intero*/
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
	}

	/*Verifica se all'interno della borsa è possibile aggiungere un'attrezzo con un determinato peso,
	 * riceve come parametro l'attrezzo da aggiungere.
	 * Restituisce un valore booleano true se è possibile, false altrimenti*/
	public boolean addIsPossible(Attrezzo attrezzo) {
		return (this.getPeso()+attrezzo.getPeso()<= this.getPesoMax());
	}

	/*metodo che aggiunge un'attrezzo nella borsa del giocatore, restituisce un booleano.
	 * restituisce true se l'attrezzo è stato aggiunto, false altrimenti*/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.addIsPossible(attrezzo)) {
			// aggiungo l'attrezzo nella mappa 
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
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
		return this.attrezzi.get(nomeAttrezzo);
	}

	/*calcola il peso contenuto all'interno della borsa,
	 * restituisce il valore intero pari al peso di tutti gli attrezzi contenuti*/
	public int getPeso() {
		int peso = 0;  // valore da restituire, rappresenta la somma dei pesi degli attrezzi contenuti in Borsa
		for(Attrezzo a : this.attrezzi.values()) 
			peso = peso + a.getPeso();
		return peso;
	}

	/* Calcola se la borsa è vuota, restituisce un booleano
	 * restituisce true se la borsa è vuota, flase altrimenti*/

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}

	/*Cerca l'esistenza di un attrezzo all'interno della borsa
	 * restituisce un booleano, true se l'attrezzo è presente, false altrimenti*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/*Rimuove un'attrezzo dalla borsa del giocatore (uguagliana per nome).
	 * restituisce l'attrezzo eliminato*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
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
			for (Attrezzo a : this.attrezzi.values())
				s.append(a.toString()+" ");
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
	
	/*Restituisce una lista di attrezzi ordinati per peso ed a parità di peso ordinati per nome*/
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> l = new ArrayList<Attrezzo>();
		l.addAll(this.attrezzi.values());  // aggiungo alla lista ordinata gli attrezzi presenti nella mappa
		// ordino la nuova lista tramite l'ordinatore esterno
		Collections.sort(l, new ComparatoreAttrezzoPerPeso());
		return l;
	}	
	
	
	/*Restituisce un insieme di attrezzi ordinati per nome*/
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		// restituisco l'insieme ordinato tramite l'ordinamento naturale
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}
	
	/*Restituisce una mappa che ad ogni intero (chiave) restituisce un insieme di attrezzi con quel dato peso*/
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> tmp;
		// implemento la mappa 
		for(Attrezzo a : this.attrezzi.values()) {
			// se la mappa contiene già la chiave aggiorno l'insieme degli attrezzi
			if(mappa.containsKey(a.getPeso())) {
				tmp = mappa.get(a.getPeso());
				tmp.add(a);
			}
			else {
				// altrimenti creo una nuova coppia nella mappa
				tmp = new TreeSet<Attrezzo>();
				tmp.add(a);
				mappa.put(a.getPeso(), tmp);
			}
		}
		return mappa;
	}
	
	/*Restituisce un insieme di attrezzi ordinati per peso ed a parità di peso ordinati per nome*/
	/*public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		//return new HashSet<Attrezzo>(this.attrezzi.values());
		return new TreeSet<Attrezzo>(this.attrezzi.values(), new ComparatoreAttrezzoPerPeso());
	}*/

}