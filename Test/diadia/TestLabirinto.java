package diadia;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestLabirinto {
	
	Labirinto labirinto;
	Stanza stanzaIniziale = new Stanza("atrio");
	Stanza stanzaFinale = new Stanza("Biblioteca");
	
	@Before
	public void setUp() {
		// creo il labirinto
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addStanzaVincente("Biblioteca")
				.getLabirinto();
	}
	

	@Test
	public void test_getStanzaFinale() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());		
	}
	
	@Test
	public void test_getStanzaIniziale() {
		assertEquals("atrio", labirinto.getStanzaCorrente().getNome());	
	}
}		
