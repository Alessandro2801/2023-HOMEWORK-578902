package it.uniroma3.diadia.comando;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/* Comando Posa (il giocatore vuole posare un attrezzo dalla sua borsa in una stanza */
public class ComandoPosa implements Comando{

	private String nomeAttrezzo;  // attrezzo da posare nella stanza corrente
	private IOConsole io = new IOConsole();

	/*Operazione di prelevare un oggetto dalla Borsa del giocatore e posarlo all'interno della stanza corrente,
	 * in cui si trova il giocatore (uguaglianza per nome) */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoPosato = null;  // attrezzo da posare
		boolean posato = false;  // verifica dello spostamento dell'attrezzo

		if(this.nomeAttrezzo==null) 
			this.io.mostraMessaggio("Specificare l'attrezzo da posare!");
		else {
			if(partita.getGiocatore().getBorsa().isEmpty())
				this.io.mostraMessaggio("Impossibile posare l'attrezzo, la borsa non contiene nessun attrezzo!");
			else {
				// verifico la presenza dell'attrezzo cercato all'interno della borsa
				if(partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo)) {
					// verifico se è possibile aggiungere un'attrezzo alla stanza corrente
					if(partita.getStanzaCorrente().addIsPossible()) {
						// prendo l'attrezzo dalla borsa e lo poso all'interno della stanza corrente
						attrezzoPosato = partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
						if(partita.getStanzaCorrente().addAttrezzo(attrezzoPosato))
							posato = true;
					}
					else
						this.io.mostraMessaggio("Impossibile posare attrezzo, la stanza è piena!");			
				}
				else
					this.io.mostraMessaggio("Impossibile posare l'attrezzo, questo attrezzo non è presente nella borsa");
			}
			if(posato)
				this.io.mostraMessaggio("L'attrezzo è stato posato");

			// stampo la descrizione della stanza corrente e della borsa del giocatore
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
		}
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override 
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
}
