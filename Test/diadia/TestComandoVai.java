package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.ComandoVai;

public class TestComandoVai {
	Partita partita;
	Labirinto labirinto;
	Comando comando = new ComandoVai();
	String direzioneProssimaStanza = "nord";
	
	@Before
	public void setup() {
		// creo il labirinto
		this.labirinto = new LabirintoBuilder().addStanzaIniziale("atrio")
				.addStanza("aula magna")
				.addAdiacenza("atrio", "aula magna", direzioneProssimaStanza)
				.getLabirinto();
		
		this.partita = new Partita(this.labirinto);
		// effettuo l'operazione di spostarmi dalla stanza corrente alla "prossimaStanza"
		this.comando.setParametro(this.direzioneProssimaStanza);
		this.comando.esegui(this.partita);
	}

	@Test
	public void test_ComandoVai() {
		assertEquals("aula magna", this.partita.getStanzaCorrente().getNome());
	}

}
