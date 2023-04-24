package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comando.Comando;
import it.uniroma3.diadia.comando.FabbricaDiComandiFisarmonica;

public class TestFabbricaDiComandiFisarmonica {
	Comando comandoVai;
	Comando comandoPrendi;
	Comando comandoPosa;
	Comando comandoFine;
	Comando comandoAiuto;
	Comando comandoGuarda;

	@Before
	public void setup() {
		this.comandoVai = new FabbricaDiComandiFisarmonica().costruisciComando("vai sud");
		this.comandoPrendi = new FabbricaDiComandiFisarmonica().costruisciComando("prendi osso");
		this.comandoPosa = new FabbricaDiComandiFisarmonica().costruisciComando("posa lanterna");
		this.comandoFine = new FabbricaDiComandiFisarmonica().costruisciComando("fine");
		this.comandoAiuto = new FabbricaDiComandiFisarmonica().costruisciComando("aiuto");
		this.comandoGuarda = new FabbricaDiComandiFisarmonica().costruisciComando("guarda");
	}
	
	@Test
	public void test_ComandoVai() {
		assertEquals("vai", this.comandoVai.getNome());
	}
	
	@Test
	public void test_ComandoVai2() {
		assertEquals("sud", this.comandoVai.getParametro());
	}
	
	@Test
	public void test_ComandoPrendi() {
		assertEquals("prendi", this.comandoPrendi.getNome());
	}
	
	@Test
	public void test_ComandoPrendi2() {
		assertEquals("osso", this.comandoPrendi.getParametro());
	}
	
	@Test
	public void test_ComandoPosa() {
		assertEquals("posa", this.comandoPosa.getNome());
	}
	
	
	@Test
	public void test_ComandoPosa2() {
		assertEquals("lanterna", this.comandoPosa.getParametro());
	}
	@Test
	public void test_ComandoAiuto() {
		assertEquals("aiuto", this.comandoAiuto.getNome());
	}
	
	@Test
	public void test_ComandoFine() {
		assertEquals("fine", this.comandoFine.getNome());
	}
	
	@Test
	public void test_ComandoGuarda() {
		assertEquals("guarda", this.comandoGuarda.getNome());
	}

}
