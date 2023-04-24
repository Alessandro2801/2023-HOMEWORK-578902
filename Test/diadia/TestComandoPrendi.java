package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoPrendi;

public class TestComandoPrendi {
	Partita partita = new Partita();
	Comando comando = new ComandoPrendi();
	Attrezzo attrezzo = new Attrezzo("orologio", 3);
	String nomeAttrezzo;
	
	@Before
	public void setup() {
		partita.getStanzaCorrente().addAttrezzo(this.attrezzo);  // aggiungo l'attrezzo alla stanza corrente del giocatore
		this.nomeAttrezzo = this.attrezzo.getNome();
		// effettuo l'operazione di prendere l'attrezzo dalla stanza e posarlo nella borsa
		this.comando.setParametro(this.nomeAttrezzo);
		this.comando.esegui(this.partita);
	}

	@Test
	public void test_ComandoPrendi() {
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo));
	}
	
	@Test
	public void test_ComandoPrendi2() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo));
	}


}
