package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {

		// PUNTO 1: CREAZIONE DEL LIBRETTO ED INSERIMENTO DEI VOTI
		
		Libretto lib = new Libretto();

		lib.add(new Voto("Analisi", 30));
		lib.add(new Voto("Chimica", 28));
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("Fisica", 18));
		
		// Lancia una IllegalArgumentException quando provo a cambiare il voto di Analisi con 60
		//lib.getVoti().get(0).setVoto(60);

		System.out.println("Libretto\n");
		lib.stampa(); /*oppure*/ System.out.println(lib);

		// PUNTO 2: RICERCA DI TUTTI I VOTI == 25
		
		System.out.println("\nVoti uguali a 25");
		lib.stampa25();

		// PUNTO 3: RICERCA DI UN VOTO
		
		System.out.println("\nVoto TdP:");
		System.out.println(lib.getMarkfromClass("TdP"));
		System.out.println("\nVoto tdp:");
		System.out.println(lib.getMarkfromClass("tdp"));
		System.out.println("\nVoto Topologia:");
		System.out.println(lib.getMarkfromClass("Topologia"));

		// PUNTO 4, 5, 6: MODIFICA DEL METODO Add()
		
		System.out.println("\nAggiungo TdP 25");
		lib.add(new Voto("TdP", 25));

		System.out.println("\nAggiungo TdP 27");
		lib.add(new Voto("TdP", 27));

		System.out.println("\nLibretto");
		System.out.println(lib.toString());

		// PUNTO 7: LIBRETTO "MIGLIORATO"
		
		Libretto newLib = new Libretto(lib.getVoti());

		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());

		System.out.println("Alzo i voti sul nuovo libretto");
		newLib.alzaVoti();

		System.out.println("Libretto");
		System.out.println(lib.toString());

		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());

		// PUNTO 8: SORTING
		
		System.out.println("Ordinamento alfabetico");
		
//		List<String> prova = new ArrayList<>();
//		prova.add("Analisi"); prova.add("Chimica"); prova.add("TdP"); prova.add("Anatomia"); prova.add("Meccanica");
//		Collections.sort(prova);
//		System.out.println("\nProva:");
//		System.out.println(prova);
		
		// Usa l'ordinamento definito in Voto (metodo compareTo)
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
		
		// PUNTO 9: CANCELLA VOTI < 24
		
		System.out.println("\nNuovo Libretto senza voti < 24");
		lib.cancella24();
		System.out.println(lib.toString());
		
	}

}
