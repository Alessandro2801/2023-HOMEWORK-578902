package diadia;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {
	
	Borsa borsa = new Borsa();
	Attrezzo lanterna = new Attrezzo("lanterna", 7);
	Attrezzo osso = new Attrezzo("osso", 4);
	Attrezzo telefono = new Attrezzo("telefono", 2);
	Attrezzo martello = new Attrezzo("martello", 3);
	Attrezzo orologio = new Attrezzo("orologio", 4);
	Attrezzo accendino = new Attrezzo("accendino", 2);
	

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
	
	@Test
	public void test_listaOrdinataPerPeso() {
		this.borsa.addAttrezzo(this.osso);
		this.borsa.addAttrezzo(this.telefono);
		this.borsa.addAttrezzo(this.martello);
		List<Attrezzo> l = this.borsa.getContenutoOrdinatoPerPeso();
		assertEquals("telefono", l.get(0).getNome());
		assertEquals("martello", l.get(1).getNome());
		assertEquals("osso", l.get(2).getNome());
	}
	
	@Test
	public void test_listaOrdinataPerNome() {
		this.borsa.addAttrezzo(this.osso);
		this.borsa.addAttrezzo(this.martello);
		SortedSet<Attrezzo> l = this.borsa.getContenutoOrdinatoPerNome();
		assertEquals("martello", l.first().getNome());
		assertEquals("osso", l.last().getNome());
	}
	

}
