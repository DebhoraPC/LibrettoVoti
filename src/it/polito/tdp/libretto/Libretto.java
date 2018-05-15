package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<>();
	}

	public Libretto(List<Voto> voti) {
		// ERRORE #1: shallow copy della lista
		// this.voti = voti;

		// ERRORE #2: shallow copy degli oggetti Voti all'interno della lista
		// this.voti = new ArrayList<Voto>(voti);

		// ESSORE #3 (COME IL #2)
		 this.voti = new ArrayList<Voto>();
		// for (Voto v : voti) {
		//	 this.voti.add(v);
		// }

		// VERSIONE CORRETTA: DEEP COPY
		this.voti = new ArrayList<Voto>();
		for (Voto v : voti) {
			this.voti.add(new Voto(v.getEsame(), v.getVoto()));
		}
		
	}

	public void add(Voto v) {
		if (this.voti.contains(v)) {
			System.out.println("Il voto esiste gia'");
			return;
		}
		for (Voto voto : this.voti) {
			if (voto.getEsame().equals(v.getEsame())) {
				System.out.println("Trovato lo stesso esame (aggiorno il voto)");
				voto.setVoto(v.getVoto());
				return;
			}
		}
		this.voti.add(v);
	}

	public List<Voto> getVoti() {
		return this.voti;
	}

	public void alzaVoti() {
		for (Voto v : this.voti) {
			if (v.getVoto() >= 24) {
				v.setVoto(v.getVoto() + 2);
			} else if (v.getVoto() >= 18) {
				v.setVoto(v.getVoto() + 1);
			}
		}
	}

	public void stampa25() {
		for (Voto v : this.voti) {
			if (v.getVoto() == 25) {
				System.out.println(v);
			}
		}
	}

	public void stampa() {
		System.out.println("Ci sono " + voti.size() + " voti");
		for (Voto v : this.voti) {
			System.out.println(v);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ci sono " + voti.size() + " voti\n");
		for (Voto v : this.voti) {
			sb.append(v);
			sb.append("\n");
		}
		return sb.toString();
	}

	public String getMarkfromClass(String nomeCorso) {
		for (Voto v : this.voti) {
			// ERRORE: MAI USARE == PER IL CONFRONTO
			// if (v.getEsame().toLowerCase() == nomeCorso.toLowerCase()) {
			// return String.valueOf(v.getVoto());
			// }

			// VERSIONE CORRETTA
			// esame.toLowerCase().equals(esameCercato.toLowerCase()) 
			// esame.equalsIgnoreCase(esameCercato)
			if (v.getEsame().toLowerCase().equals(nomeCorso.toLowerCase())) {
				return String.valueOf(v.getVoto());
			}
		}
		return nomeCorso + " non trovato!";
	}

	public void cancella24() {
		
		for (int i = 0; i < voti.size(); i++) {
			if (voti.get(i).getVoto() < 24)
				voti.remove(i);
		}
		
	}
	
}
