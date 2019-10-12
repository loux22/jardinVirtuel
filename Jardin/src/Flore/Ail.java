package Flore;

import java.util.HashMap;

public class Ail extends Vegetal implements IRacePure{
	
	public Ail() {
		super("a","A");
	}
	
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Ail",panier.get("Ail") + 3);
	}

}
