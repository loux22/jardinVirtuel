package Flore;

import java.security.KeyStore.Entry;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

public class Bettrave extends Vegetal implements IOgm{

	public Bettrave() {
		super("b","B");
	}
	
	public SimpleEntry<Integer, Integer> seDupliquer(int longueur, int largeur) {
		SimpleEntry<Integer, Integer> entry = new SimpleEntry<Integer, Integer>(longueur, largeur);
		return entry;
	}
}
