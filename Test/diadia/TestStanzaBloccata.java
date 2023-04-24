package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoVai;

public class TestStanzaBloccata {
	StanzaBloccata stanzaBloccata = new StanzaBloccata("atrio", "nord", "chiave");
	Stanza stanza = new Stanza("cassaforte");
	Attrezzo attrezzosblocca = new Attrezzo("chiave", 2);
	Partita partita = new Partita();

	@Before
	public void setup() {
		this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanza); // imposto come stanza adiacente la stanza bloccata
	}
	
	@Test
	public void test_StanzaBloccata() {
		this.stanzaBloccata.addAttrezzo(this.attrezzosblocca); // aggiungo l'attrezzo sbloccante alla stanza bloccata
		Comando comando = new ComandoVai();
		comando.setParametro("nord");
		comando.esegui(this.partita);
		assertTrue(this.stanzaBloccata.getStanzaAdiacente("nord").getNome().equals("cassaforte"));
	}
	
	@Test
	public void test_StanzaBloccata2() {
		Comando comando = new ComandoVai();
		comando.setParametro("nord");
		comando.esegui(this.partita);
		assertTrue(this.stanzaBloccata.getStanzaAdiacente("nord").getNome().equals("atrio"));
	}

}
