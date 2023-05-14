package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoPosa;


public class TestComandoPosa {

	Comando comando = new ComandoPosa();
	Labirinto labirinto;
	Partita partita;
	Attrezzo a = new Attrezzo("osso", 3);


	@Before
	public void setup() {
		// creo il labirinto
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.getLabirinto();
		
		this.partita = new Partita(this.labirinto);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.a);
		
		// effettuo l'operazione di posare l'attrezzo nella stanza corrente
		this.comando.setParametro(this.a.getNome());
		this.comando.esegui(partita);
	}
	
	@Test
	public void test_ComandoPosa1() {
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.a.getNome()));
	}
	
	@Test
	public void test_ComandoPosa2() {
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(this.a.getNome()));
	}

}
