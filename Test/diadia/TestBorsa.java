package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {
	
	Borsa borsa = new Borsa();
	Attrezzo lanterna = new Attrezzo("lanterna", 7);
	Attrezzo osso = new Attrezzo("osso", 4);

	@Test
	public void test_getPesoMax() {
		assertEquals(10, this.borsa.getPesoMax());
	}
	
	@Test
	public void test_getPeso() {
		this.borsa.addAttrezzo(this.lanterna);  // borsa con la lanterna di peso 7
		assertEquals(7, this.borsa.getPeso());
	}
	
	@Test
	public void test_isEmpty() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void test_isEmpty2() {
		this.borsa.addAttrezzo(this.lanterna);  // borsa con la lanterna
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void test_addAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(this.lanterna));
	}
	
	@Test
	public void test_addAttrezzoSuperandoPesoMax() {
		this.borsa.addAttrezzo(this.osso);  // borsa con osso peso 4
		assertFalse(this.borsa.addAttrezzo(lanterna));
	}
	
	@Test
	public void test_getAttrezzo() {
		assertEquals(null, this.borsa.getAttrezzo("osso"));
	}
	
	@Test
	public void test_getAttrezzo2() {
		this.borsa.addAttrezzo(osso);
		assertEquals(this.osso, this.borsa.getAttrezzo("osso"));
	}
	
	@Test
	public void test_hasAttrezzo() {
		assertFalse(this.borsa.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void test_hasAttrezzo2() {
		this.borsa.addAttrezzo(lanterna);
		assertTrue(this.borsa.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void test_removeAttrezzoBorsaVuota() {
		assertEquals(null, this.borsa.removeAttrezzo("osso"));
	}
	
	@Test
	public void test_removeAttrezzoNonPresente() {
		this.borsa.addAttrezzo(lanterna);
		assertEquals(null, this.borsa.removeAttrezzo("osso"));
	}
	
	@Test
	public void test_removeAttrezzoPresente() {
		this.borsa.addAttrezzo(osso);
		assertEquals(this.osso, this.borsa.removeAttrezzo("osso"));
	}

}
