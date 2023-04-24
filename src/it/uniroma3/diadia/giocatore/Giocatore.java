package it.uniroma3.diadia.giocatore;

/**
 * Classe Giocaote - classe che gestisce un giocatore all'interno della partita
 * gestisce i cfu
 * 
 * @author docente di POO 
 * @see Borsa
 * @version base
*/

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	/*costruttore oggetto giocatore*/
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/*restituisce la borsa del giocatore*/
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	/*imposta la borsa del giocatore*/
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	
	/*restituisce i cfu del giocatore*/
	public int getCfu() {
		return this.cfu;
	}
	
	/*imposta i cfu del giocatore*/
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	

}
