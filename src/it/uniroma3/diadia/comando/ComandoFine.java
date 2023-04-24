package it.uniroma3.diadia.comando;



import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/*  Comando Fine (si vuole smettere di giocare)  */

public class ComandoFine implements Comando {
	private IOConsole io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere di giocare
	}
	
	@Override
	public String getNome(){
		return "fine";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}	
	

}
