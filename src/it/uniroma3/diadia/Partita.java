package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Labirinto, Stanza, Giocatore
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;

	// Costruttore di Partita
	public Partita(){
		this.labirinto = new Labirinto();
		labirinto.creaLabirinto();
		this.giocatore = new Giocatore();
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.finita = false;

	}


	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}


	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}

	/* metodo che verifica se i CFU del giocatore sono esauiriti. 
	 * Restituisce true se il giocatore ha ancora a disposizione dei CFU, false altrimenti*/
	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu()>0)
			return true;
		else
			return false;
	}

}
