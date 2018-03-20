package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {

		// PUNTO 1: creazione del libretto ed inserimento dei Voti
		Libretto lib = new Libretto();

		lib.add(new Voto("Analisi", 30));
		lib.add(new Voto("Chimica", 28));
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("Fisica", 18));

		System.out.println("Libretto");
		lib.stampa();

		// PUNTO 2: ricerca di tutti i voti == 25
		System.out.println("\nVoti uguali a 25");
		lib.stampa25();

		// PUNTO 3: ricerca di un voto
		System.out.println("\nVoto TdP:");
		System.out.println(lib.getMarkfromClass("TdP"));
		System.out.println("\nVoto tdp:");
		System.out.println(lib.getMarkfromClass("tdp"));

		// PUNTO 4, 5, 6: modifica metodo Add()
		System.out.println("\nAggiungo TdP 25");
		lib.add(new Voto("TdP", 25));

		System.out.println("\nAggiungo TdP 27");
		lib.add(new Voto("TdP", 27));

		System.out.println("\nLibretto");
		System.out.println(lib.toString());

		// PUNTO 7: libretto "migliorato"
		Libretto newLib = new Libretto(lib.getVoti());

		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());

		System.out.println("Alzo i voti sul nuovo libretto");
		newLib.alzaVoti();

		System.out.println("Libretto");
		System.out.println(lib.toString());

		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());

		// PUNTO 8: sorting
		// Usa l'ordinamento definito in Voto (metodo compareTo)
		System.out.println("Ordinamento alfabetico");
		Collections.sort(newLib.getVoti());

		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());

		System.out.println("Ordinamento numerico");
		// Usa un ordinamento specifico
		Collections.sort(newLib.getVoti(), new Comparator<Voto>() {
			@Override
			public int compare(Voto o1, Voto o2) {
				return -(o1.getVoto() - o2.getVoto());
			}
		});

		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());
	}

}
