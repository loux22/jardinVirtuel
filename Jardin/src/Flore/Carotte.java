package Flore;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure{

	public Carotte() {
		super("c","C");
	}
	
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Carotte",panier.get("Carotte") + 3);
	}
}
