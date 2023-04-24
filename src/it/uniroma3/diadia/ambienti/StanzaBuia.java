package it.uniroma3.diadia.ambienti;

/* Stanza Buia: a meno che all'interno della stanza non sia presente uno specifico attrezzo,
 * la stanza rimane buia e non è possibile vedere all'interno della stanza*/
public class StanzaBuia extends Stanza {
	private String attrezzoLuce;  // attrezzo per vedere nella stanza buia
	
	// Costruttore della Stanza Buia
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoLuce = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzoLuce))
				return "qui c'è un buio pesto";
		else // altrimenti invoca il classico metodo "getDescrizione"
			return super.getDescrizione();
	}

}
