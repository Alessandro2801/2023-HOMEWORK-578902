package it.uniroma3.diadia.ambienti;


/**
 * Classe Labirinto - un labirinto in un gioco di ruolo.
 * Questa classe ha il compito di collegare le varie stanze del gioco.
 * 
 * @author docente di POO 
 * @see Attrezzo, Stanza
 * @version base
*/

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	
	
	/*metodo che restituisce la stanza finale del labirinto*/
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente = stanza;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}
		
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	


	

}
