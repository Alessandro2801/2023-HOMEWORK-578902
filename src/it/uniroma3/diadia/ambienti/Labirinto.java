package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Labirinto - un labirinto in un gioco di ruolo.
 * Questa classe ha il compito di collegare le varie stanze dle gioco.
 * 
 * @author docente di POO 
 * @see Attrezzo, Stanza
 * @version base
*/

public class Labirinto {
	 private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	
	public void creaLabirinto() {
		/*crea le stanze del labirinto*/
		Stanza atrio = new Stanza ("atrio");
		Stanza aulaN11 = new Stanza ("Aula N10");
		Stanza aulaN10 = new Stanza ("Aula N10");
		Stanza laboratorio = new Stanza ("Laboratorio Campus");
		Stanza biblioteca = new Stanza ("Biblioteca");
		
		/*crea gli attrezzi*/
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);
		
		/*colleghiamo le stanze del labirinto*/
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaIniziale = atrio;  
        this.stanzaFinale = biblioteca;	
	}
	
	/*metodo che restituisce la stanza finale del labirinto*/
	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}
	
	/*metodo che restituisce la stanza iniziale del labirinto*/
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	

}
