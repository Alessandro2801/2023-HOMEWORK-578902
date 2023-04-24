package it.uniroma3.diadia.comando;




import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/* Comando Prendi (il giocatore vuole prendere un attrezzo dalla stanza corrente e posarlo nella borsa) */
public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;  // nome dell'attrezzo da prendere nella stanza e posare in borsa
	private IOConsole io = new IOConsole();

	/*Operazione di prendere un attrezzo dalla stanza corrente in cui si trova il giocatore e posarlo nella borsa
	 * (uguaglianza per nome) */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoPreso = null; // attrezzo della stanza da prendere e posare nella borsa
		boolean preso = false;  // verifica dello spostamento dell'attrezzo

		if(this.nomeAttrezzo==null)
			this.io.mostraMessaggio("Specificare l'attrezzo da prendere!");
		else {
			if(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
				attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);

				/*controllo se è possibile aggiungere e trasportare l'attrezzo scelto all'interno della borsa*/
				if(partita.getGiocatore().getBorsa().addIsPossible(attrezzoPreso)) {
					// verifico lo spostamento dell'attrezzo dalla stanza corrente alla borsa
					if(partita.getStanzaCorrente().removeAttrezzo(attrezzoPreso) && partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
						preso = true;  // lo spostamento è avvenuto
					}
				}
				else
					this.io.mostraMessaggio("Impossibile posare l'attrezzo, l'attrezzo non può essere trasportato nella borsa");

			}
			else
				this.io.mostraMessaggio("Impossibile posare l'attrezzo, l'attrezzo cercato non è presente all'interno della stanza");
			if(preso)
				this.io.mostraMessaggio("Attrezzo preso e posato in Borsa!");

			// stampo la descrizione della stanza corrente e della borsa del giocatore
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
		}

	}

	@Override 
	public String getNome() {
		return "prendi";
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
