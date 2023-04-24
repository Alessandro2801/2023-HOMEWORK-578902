package diadia;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestLabirinto {
	
	Labirinto labirinto = new Labirinto();
	Stanza stanzaIniziale = new Stanza("atrio");
	Stanza stanzaFinale = new Stanza("Biblioteca");
	
	@Before
	public void setUp() {
		this.labirinto.creaLabirinto();	
	}
	

	@Test
	public void test_getStanzaFinale() {
		assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());		
	}
	
	@Test
	public void test_getStanzaIniziale() {
		assertEquals("atrio", labirinto.getStanzaIniziale().getNome());	
	}
}		
