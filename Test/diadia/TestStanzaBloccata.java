package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoVai;

public class TestStanzaBloccata {
	StanzaBloccata stanzaBloccata = new StanzaBloccata("atrio", "nord", "chiave");
	Stanza stanza = new Stanza("cassaforte");
	Attrezzo attrezzosblocca = new Attrezzo("chiave", 2);
	Partita partita;
	Labirinto labirinto;

	@Before
	public void setup() {
		// creo il labirinto
		this.labirinto = new LabirintoBuilder()
				.addStanzaBloccata("atrio", "nord", "chiave")
				.addStanza("cassaforte")
				.getLabirinto();
		
		this.partita = new Partita(this.labirinto);
		this.partita.setStanzaCorrente(this.stanzaBloccata);
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
