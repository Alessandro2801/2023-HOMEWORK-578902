package it.uniroma3.diadia.comando;



import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/* Comando Aiuto (stampa informazioni di aiuto al giocatore, relative alle operazioni pssibili da fare) */
public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IOConsole io = new IOConsole();
	
	/*stampa le possibile operazioni che l'utente può svolgere*/
	@Override
	public void esegui(Partita partita) {
			for(int i=0; i< elencoComandi.length; i++) 
				this.io.mostraMessaggio(elencoComandi[i]+" ");
				this.io.mostraMessaggio("");		
		
	}
	
	@Override
	public String getNome() {
		return "aiuto";
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override 
	public String getParametro() {
		return "";
	}
	
	

}
