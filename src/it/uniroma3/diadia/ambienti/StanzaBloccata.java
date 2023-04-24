package it.uniroma3.diadia.ambienti;



/* Stanza Bloccata: a meno che all'interno della stanza non sia presente uno specifico attrezzo,
 * la stanza rimane bloccata e di conseguenza non vi si può accedere*/
public class StanzaBloccata extends  Stanza {
	private String direzioneBloccata;  // direzione che porta da una stanza adiacente alla stanza bloccata
	private String attrezzoSblocca;  // attrezzo che deve essere presente all'interno della stanza bloccata per sbloccarla
	
	// Costruttore della Stanza Bloccata
	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSblocca = attrezzo;
	}
	
	/*metodo che, data una direzione, conseidera la presenza dell'attrezzo sbloccante all'interno della stanza bloccata
	 * per assicurare che sia possibile accedervi.
	 * Restituisce il riferimento alla stanza bloccata se l'attrezzo sbloccante è presente, mentre restituisce 
	 * il riferimento alla stanza precedente se l'attrezzo non fosse presente */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		// se la stanza è bloccata allora restituisci il riferimento alla stanza di partenza
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSblocca)) {
			return this;
		}
		else  // altrimenti svolgi il classico metodo "getStanzaAdiacente"
			return super.getStanzaAdiacente(direzione);
	}

	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + this.attrezzoSblocca + " e posalo nella stanza";

		if(!this.hasAttrezzo(this.attrezzoSblocca))
			return bloccata;
		return super.getDescrizione();

	}
	
	

}
