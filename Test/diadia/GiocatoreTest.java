package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore giocatore = new Giocatore();
	Borsa borsa = new Borsa();
	int cfu = 10;

	@Test
	public void test_getCfu() {
		assertEquals(20, this.giocatore.getCfu());
	}
	
	@Test
	public void test_getCfu2() {
		giocatore.setCfu(cfu);
		assertEquals(10, this.giocatore.getCfu());
	}
	
	@Test
	public void test_getBorsa() {
		this.giocatore.setBorsa(borsa);
		assertEquals(this.borsa, this.giocatore.getBorsa());
	}
	

}
