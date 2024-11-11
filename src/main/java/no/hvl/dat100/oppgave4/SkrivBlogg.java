package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.*;
import no.hvl.dat100.oppgave6.HtmlBlogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		boolean completed = false;

		PrintWriter writer = null;

		Innlegg[] innleggTab = samling.getSamling();

		try {
			writer = new PrintWriter(mappe + filnavn);
			writer.println(samling.toString());
			completed = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		return completed;
	}
}
