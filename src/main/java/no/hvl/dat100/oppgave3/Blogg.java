package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	private Innlegg[] innleggtabell;
	private int nesteLedig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int pos = 0;
		for (int i = 0; i < nesteLedig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return pos;
			}
			pos++;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		for (Innlegg innlegg : innleggtabell) {
			if (innlegg == null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			innleggtabell[nesteLedig++] = innlegg;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = nesteLedig + "\n";

		for (int i = 0; i < nesteLedig; i++) {
			str += innleggtabell[i].toString();
		}

		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTab = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteLedig; i++) {
			nyTab[i] = innleggtabell[i];
		}
		innleggtabell = nyTab;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}