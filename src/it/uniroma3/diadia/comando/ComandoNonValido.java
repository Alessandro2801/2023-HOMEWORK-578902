package it.uniroma3.diadia.comando;




import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/* Comando Non Valido */
public class ComandoNonValido implements Comando {
	private IOConsole io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Comando non valido");
		this.io.mostraMessaggio("Scrivere 'aiuto' per la lista comandi");
	}
	
	
	@Override
	public String getNome(){
		return "non valido";
	}
	@Override
	public String getParametro() {
		return "";
	}
	@Override
	public void setParametro(String parametro) {
		
	}
	
	

}
