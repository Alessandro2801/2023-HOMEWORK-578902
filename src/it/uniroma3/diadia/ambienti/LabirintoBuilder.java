package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Map<String, Stanza> stanzeDelLabirinto;  // mappa delle stanze che fanno parte del labirinto
	
	// costruttore no args
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanzeDelLabirinto = new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	
	public Map<String, Stanza> getMappaStanze() {
		return this.stanzeDelLabirinto;
	}
	
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		// imposta la stanza come stanza iniziale del labirinto e la aggiungo alla mappa 
		this.labirinto.setStanzaCorrente(s);
		this.stanzeDelLabirinto.put(nomeStanza, s);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.labirinto.setStanzaVincente(s);
		this.stanzeDelLabirinto.put(nomeStanza, s);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.stanzeDelLabirinto.put(nomeStanza, s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso, String nomeStanza) {
		boolean esiste = false;
		// verifico se nel labirinto è gia presente un attrezzo con questo nome
		for(Stanza stanza : this.stanzeDelLabirinto.values()) {
			if(stanza.hasAttrezzo(nomeAttrezzo))
					esiste = true;
		}
		// se l'attrezzo non è presente in nessuna stanza del labirinto allora lo aggiungo 
		if(!esiste) {
			Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
			Stanza s = this.stanzeDelLabirinto.get(nomeStanza);
			s.addAttrezzo(a);
			return this;
		}
		else
			return this;
		
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaAttuale, String stanzaAdiacente, String direzione) {
		Stanza s = this.stanzeDelLabirinto.get(stanzaAttuale);
		Stanza s1 = this.stanzeDelLabirinto.get(stanzaAdiacente);
		s.impostaStanzaAdiacente(direzione, s1);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzo) {
		Stanza s = new StanzaBuia(nomeStanza, nomeAttrezzo);
		this.stanzeDelLabirinto.put(nomeStanza, s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzione, String nomeAttrezzo) {
		Stanza s = new StanzaBloccata(nomeStanza, direzione, nomeAttrezzo);
		this.stanzeDelLabirinto.put(nomeStanza, s);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
		Stanza s = new StanzaMagica(nomeStanza, sogliaMagica);
		this.stanzeDelLabirinto.put(nomeStanza, s);
		return this;
	}
}
