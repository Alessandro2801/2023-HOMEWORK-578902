package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;


public class TestPartita {
	
	Labirinto labirinto;
	Partita partita;
	
	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addStanzaVincente("biblioteca")
				.getLabirinto();
		this.partita = new Partita(this.labirinto);
	}
	

	@Test
	public void test_isFinita1() {
		assertFalse(partita.isFinita());		
	}
	
	@Test
	public void test_isFinitaTramiteVittoria() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void test_isFinita3() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void test_giocatoreIsVivo() {
		partita.getGiocatore().setCfu(4);
		assertTrue(partita.giocatoreIsVivo());
	}
	
	@Test
	public void test_giocatoreIsVivo2() {
		partita.getGiocatore().setCfu(0);
		assertFalse(partita.giocatoreIsVivo());
	}


}
