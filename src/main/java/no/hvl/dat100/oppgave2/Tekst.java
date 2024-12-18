package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {

	// TODO: objektvariable 

	private String tekst;

	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst = tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "TEKST\n" + this.getId() + "\n" + this.getBruker() + "\n" + this.getDato() + "\n" + this.getLikes() + "\n" + this.getTekst() + "\n";
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {
		return "\t\t<h2>" + super.getBruker() + "@" + super.getDato() + " [" + super.getLikes() + "]" + "</h2>\n\t\t<p>" + tekst + "</p>\n\t\t<hr>\n";
	}
}
