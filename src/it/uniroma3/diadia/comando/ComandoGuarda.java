package it.uniroma3.diadia.comando;




import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;


/* Comando Guarda (da informazioni relative alla stanza corrente in cui si trova il giocatore,
 * alla borsa del giocatore ed allo stato della partita)*/
public class ComandoGuarda implements Comando {
	private IOConsole io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("CFU rimasti :" + partita.getGiocatore().getCfu());
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
	
}
