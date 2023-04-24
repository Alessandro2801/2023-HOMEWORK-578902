package it.uniroma3.diadia.comando;




import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/* Comando Vai (il giocatore vuole spostarsi da una stanza ad un'altra secondo una direzione */
public class ComandoVai implements Comando {
	
	private String direzione;  // direzione verso la quale si vuole spostare il giocatore
	private IOConsole io = new IOConsole();
	
	@Override
	public void esegui (Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();  // stanza corrente del giocatore
		Stanza prossimaStanza = null;  // la stanza di arrivo in seguito al comando vai 
		
		if (this.direzione==null) {
			this.io.mostraMessaggio("Devi specificare una direzione, dove vuoi andare?");
			// return;
		}
		else {
  // imposto come prossima stanza del giocatore la stanza adiacente alla stanza corrente del giocatore nella direzione scelta
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);  
			if(prossimaStanza==null) {
				this.io.mostraMessaggio("Direzione inesistente!");
				// return;
			}
			// settiamo la nuova stanza corrente del giocatore
			else {
				partita.setStanzaCorrente(prossimaStanza);
				this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
				// decrmento i cfu del giocatore in seguito allo spostamento nella nuova stanza
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			}
		}
	}
	
	@Override
	public String getNome() {
		return "vai";
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
}
