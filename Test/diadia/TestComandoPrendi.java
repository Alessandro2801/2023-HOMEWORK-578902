package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoPrendi;

public class TestComandoPrendi {
	Partita partita;
	Labirinto labirinto;
	Comando comando = new ComandoPrendi();
	Attrezzo a = new Attrezzo("orologio", 5);

	
	@Before
	public void setup() {
		// creo il labirinto
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("atrio").
				addAttrezzo(this.a.getNome(), this.a.getPeso() , "atrio")
				.getLabirinto();
		
		this.partita = new Partita(this.labirinto);
		// effettuo l'operazione di prendere l'attrezzo dalla stanza e posarlo nella borsa
		this.comando.setParametro(this.a.getNome());
		this.comando.esegui(this.partita);
	}

	@Test
	public void test_ComandoPrendi() {
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(this.a.getNome()));
	}
	
	@Test
	public void test_ComandoPrendi2() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(this.a.getNome()));
	}


}
