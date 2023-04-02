package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza stanza = new Stanza("aula");
	Attrezzo osso = new Attrezzo("osso", 3);
	Attrezzo lanterna = new Attrezzo("lanterna", 6);
	Stanza adiacente = new Stanza("Biblioteca");
	
	@Before
	public void setUp() {
		stanza.addAttrezzo(osso);
		this.stanza.impostaStanzaAdiacente("nord", this.adiacente);
	}

	@Test
	public void test_hasAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void test_hasAttrezzo2() {
		assertTrue(this.stanza.hasAttrezzo("osso"));
	}
	
	@Test
	public void test_getAttrezzo() {
		assertEquals(this.osso, this.stanza.getAttrezzo("osso"));
	}
	
	@Test
	public void test_getAttrezzo2() {
		assertEquals(null, this.stanza.getAttrezzo("lanterna"));
	}
	
	@Test
	public void test_removeAttrezzoPresente() {
		assertTrue(this.stanza.removeAttrezzo(osso));
	}
	
@Test
	public void test_removeAttrezzoNonPresente() {
		assertFalse(this.stanza.removeAttrezzo(lanterna));
	}

	@Test
	public void test_getStanzaAdiacente() {
		assertEquals(this.adiacente, this.stanza.getStanzaAdiacente("nord"));
	}

}
