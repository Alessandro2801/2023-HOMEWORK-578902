package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {
	StanzaBuia illuminata = new StanzaBuia("aula1", "lanterna");
	StanzaBuia buia = new StanzaBuia("aula2", "lanterna");
	Attrezzo attrezzoLuminoso = new Attrezzo("lanterna", 2);  // attrezzo necessario ad illuminare la stanza

	@Before
	public void setup() {
		this.illuminata.addAttrezzo(this.attrezzoLuminoso);  // aggiungo alla stanza "illuminata" l'attrezzo che la illumina
	}
	
	@Test
	public void test_StanzaBuia() {
		assertEquals("qui c'è un buio pesto", buia.getDescrizione());
	}
	
	@Test
	public void test_StanzaBuia2() {
		assertFalse(illuminata.getDescrizione().equals("qui c'è un buio pesto"));
	}

}
