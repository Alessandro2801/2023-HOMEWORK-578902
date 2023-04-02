package it.uniroma3.diadia;




import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io = new IOConsole();

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);			
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		String nome = comandoDaEseguire.getNome();

		while(nome != null) {

			if (nome.equals("fine")) {
				this.fine(); 
				return true;
			} else if(nome.equals("prendi"))
				this.prendiAttrezzo(comandoDaEseguire.getParametro());
			else if (nome.equals("posa"))
				this.posaAttrezzo(comandoDaEseguire.getParametro());
			else if (nome.equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (nome.equals("aiuto"))
				this.aiuto();
			else
				this.io.mostraMessaggio("Comando sconosciuto");
			if (this.partita.vinta()) {
				this.io.mostraMessaggio("Hai vinto!");
				return true;
			} else
				return false;

		}
		return false;

	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
			this.io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	/*prendi un'attrezzo dalla stanza e lo posa nella borsa del giocatore (uguaglianza per nome).
	 * */
	public void prendiAttrezzo(String attrezzo) {
		Attrezzo attrezzoPreso = null; // attrezzo della stanza da prendere e posare nella borsa
		boolean preso = false;  // verifica dello spstamento dell'attrezzo
		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(attrezzo);
			/*controllo se è possibile aggiungere e trasportare l'attrezzo scelto all'interno della borsa*/
			if(partita.getGiocatore().getBorsa().addIsPossible(attrezzoPreso)) {
				// verifico lo spostamento dell'attrezzo dalla stanza corrente alla borsa
				if(partita.getStanzaCorrente().removeAttrezzo(attrezzoPreso) && partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso)) {
					preso = true;  // lo spostamento è avvenuto
				}
			}
			else
				this.io.mostraMessaggio("L'attrezzo non può essere trasportato nella borsa");

		}
		else
			this.io.mostraMessaggio("L'attrezzo cercato non è presente all'interno della stanza");
		if(preso)
			this.io.mostraMessaggio("Attrezzo preso e posato in Borsa!");

		// stampo la descrizione della stanza corrente e della borsa del giocatore
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}

	/*metodo che svolge l'operazione di prelevalere un'attrezzo dalla Borsa del giocatore
	 * e posarlo nella stanza corrente in cui si trova il giocatore (uguaglianza per nome).
	 * */
	public void posaAttrezzo(String attrezzo) {
		Attrezzo attrezzoPosato = null;  // attrezzo da posare
		boolean posato = false;  // verifica dello spostamento dell'attrezzo
		if(partita.getGiocatore().getBorsa().isEmpty())
			this.io.mostraMessaggio("La borsa non contiene nessun attrezzo!");
		else {
			// verifico la presenza dell'attrezzo cercato all'interno della borsa
			if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
				// verifico se è possibile aggiungere un'attrezzo alla stanza corrente
				if(partita.getStanzaCorrente().addIsPossible()) {
					// prendo l'attrezzo dalla borsa e lo poso all'interno della stanza corrente
					attrezzoPosato = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
					if(partita.getStanzaCorrente().addAttrezzo(attrezzoPosato))
						posato = true;
				}
				else
					this.io.mostraMessaggio("Impossibile posare attrezzo, la stanza è piena!");			
			}
			else
				this.io.mostraMessaggio("Questo attrezzo non è presente nella borsa");
		}
		if(posato)
			this.io.mostraMessaggio("L'attrezzo è stato posato");
		
		// stampo la descrizione della stanza corrente e della borsa del giocatore
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());

	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}