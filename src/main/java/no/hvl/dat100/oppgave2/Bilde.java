package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;

public class Bilde extends Tekst {

	// TODO - objekt variable
	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE\n" + this.getId() + "\n" + this.getBruker() + "\n" + this.getDato() + "\n" + this.getLikes() + "\n" + this.getTekst() + "\n" + this.getUrl() + "\n";
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	@Override
	public String toHTML() {
		return "\t\t<h2>" + super.getBruker() + "@" + super.getDato() + " [" + super.getLikes() + "]" + "</h2>\n\t\t<p>" + super.getTekst() + "</p>\n\t\t<iframe src=\"" + url + "\" height=600 width=800></iframe><hr>";
	}
}
