package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {
	StanzaBuia stanza = new StanzaBuia("aula1", "lanterna");
	Attrezzo attrezzoLuminoso = new Attrezzo("lanterna", 2);  // attrezzo necessario ad illuminare la stanza

	
	@Test
	public void test_StanzaBuia() {
		assertEquals("qui c'è un buio pesto", stanza.getDescrizione());
	}
	
	@Test
	public void test_StanzaBuia2() {
		this.stanza.addAttrezzo(this.attrezzoLuminoso);  // aggiungo alla stanza buia l'attrezzo "luminoso"
		assertFalse(stanza.getDescrizione().equals("qui c'è un buio pesto"));
	}

}
