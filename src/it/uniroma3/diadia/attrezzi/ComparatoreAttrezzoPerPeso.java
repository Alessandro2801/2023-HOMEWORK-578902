package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezzoPerPeso implements Comparator<Attrezzo>{
	
	/*Paragona gli oggetti di tipo Attrezzo in base al peso ed a parità di peso in base al nome*/
	public int compare(Attrezzo a, Attrezzo b) {
		if(a.getPeso()==b.getPeso())
			return a.getNome().compareTo(b.getNome());
		else // altrimenti effettua il paragone per peso
			return a.getPeso() - b.getPeso();
	}

}
