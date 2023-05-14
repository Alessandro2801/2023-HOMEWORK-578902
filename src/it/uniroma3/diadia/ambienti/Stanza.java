package it.uniroma3.diadia.ambienti;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza{

	//static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private HashMap<String, Attrezzo> attrezzi;  // mappa degli attrezzi contenuti all'interno della stanza
	private HashMap<String, Stanza> stanzeAdiacenti;  // mappa delle stanze adiacenti ad una stanza 
	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}
	
	/*Restituisce la mappa delle stanze adiacenti*/
	public Map<String, Stanza> getMappaStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la lista di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		List<Attrezzo> listaAttrezzi = new ArrayList<Attrezzo>(this.attrezzi.values());
		return listaAttrezzi;
	}



	/*metodo che verifica se è possibile aggiungere un'attrezzo alla stanza vista la capienza massima di 10 attrezzi,
	 * restituisce un booleano, true se è possibile, false altrimenti*/
	public boolean addIsPossible() {
		return this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.addIsPossible()) {
			/* verifico se la mappa già contiene un attrezzo con questo nome,
			 * Nella stanza npon è possibile che ci siano due attrezzi con lo stesso nome*/
			if(!this.attrezzi.containsKey(attrezzo.getNome())) {
				this.attrezzi.put(attrezzo.getNome(), attrezzo); // aggiungo l'attrezzo nella mappa
				return true;
			}
			else
				return false;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for(String s : this.stanzeAdiacenti.keySet())
				risultato.append(s.toString()+" ");
		risultato.append("\nAttrezzi nella stanza: ");
		for(String a : this.attrezzi.keySet())
				risultato.append(a.toString()+" ");
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.remove(attrezzo.getNome())!=null)
			return true;  // hai eliminato l'attrezzo dalla mappa
		else 
			return false;
	}

	/*metodo che restituisce le direzioni di uscita da una stanza*/
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

}