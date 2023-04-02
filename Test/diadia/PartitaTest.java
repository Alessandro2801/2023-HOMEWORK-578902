package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;


public class PartitaTest {
	
	Partita partita = new Partita();

	@Test
	public void test_isFinita1() {
		assertFalse(partita.isFinita());		
	}
	
	@Test
	public void test_isFinitaTramiteVittoria() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaFinale());
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void test_isFinita3() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}


}
