package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoVai;

public class TestComandoVai {
	Partita partita = new Partita();
	Comando comando = new ComandoVai();
	Stanza stanzaCorrente;
	Stanza prossimmaStanza = new Stanza("aula magna");
	String direzioneProssimaStanza = "nord";
	
	@Before
	public void setup() {
		this.stanzaCorrente = this.partita.getStanzaCorrente();
		this.stanzaCorrente.impostaStanzaAdiacente(this.direzioneProssimaStanza, this.prossimmaStanza);
		// effettuo l'operazione di spostarmi dalla stanza corrente alla "prossimaStanza"
		this.comando.setParametro(this.direzioneProssimaStanza);
		this.comando.esegui(this.partita);
	}

	@Test
	public void test_ComandoVai() {
		assertEquals("aula magna", this.partita.getStanzaCorrente().getNome());
	}

}
