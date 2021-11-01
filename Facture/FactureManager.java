package me.pepe.ExamenCarrera.Ejercicio10.Facture;

import java.util.Collection;
import java.util.HashMap;

public class FactureManager {
	private HashMap<Integer, Facture> factures = new HashMap<Integer, Facture>();
	public FactureManager() {}
	public boolean hasFacture(int id) {
		return factures.containsKey(id);
	}
	public Facture getFacture(int id) {
		if (hasFacture(id)) {
			return factures.get(id);
		} else {
			return null;
		}
	}
	public Collection<Facture> getFactures() {
		return factures.values();
	}
	public Facture getFactureOpenned() {
		for (Facture fack : getFactures()) {
			if (!fack.isClosed()) {
				return fack;
			}
		}
		return null;
	}
	public boolean hasFactureOpenned() {
		for (Facture fack : getFactures()) {
			if (!fack.isClosed()) {
				return true;
			}
		}
		return false;
	}
	public void deleteFacture(int id) {
		if (hasFacture(id)) {
			factures.remove(id);
		}
	}
	public int open(Facture facture) {
		int id = factures.values().size() + 1;
		facture.setID(id);
		factures.put(id, facture);
		return id;
	}
}
