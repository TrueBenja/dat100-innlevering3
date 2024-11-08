package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

import java.util.ArrayList;

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

	@Override
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
		if (nesteLedig == innleggtabell.length) {
			utvid();
		}
		return leggTil(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
		for (int i = 0; i < nesteLedig; i++) {
			if(innleggtabell[i].erLik(innlegg)) {
				innleggtabell[i] = innleggtabell[nesteLedig - 1];
				innleggtabell[nesteLedig - 1] = null;
				nesteLedig--;
				return true;
			}
		}
		return false;
	}
	
	public int[] search(String keyword) {
		ArrayList<Integer> ids = new ArrayList<>();
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				ids.add(innleggtabell[i].getId());
			}
		}
		int[] result = new int[ids.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = ids.get(i);
		}
		return result;
	}
}