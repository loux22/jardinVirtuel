package main;

import Etat.Etat;
import Flore.Vegetal;

public class Emplacement {
	private Vegetal emplacement;
	
	public Emplacement(Vegetal emplacement) {
		this.setEmplacement(emplacement);
	}

	@Override
	public String toString() {
		if (emplacement.getEtat().name() == "Graine") {
			return emplacement.getDessin()[1][1];
		} else if(emplacement.getEtat().name() == "Germe") {
			return emplacement.getDessin()[2][1];
		} else if(emplacement.getEtat().name() == "Tige") {
			return emplacement.getDessin()[3][1];
		} else if(emplacement.getEtat().name() == "Feuille") {
			return emplacement.getDessin()[4][1];
		} else if(emplacement.getEtat().name() == "Fleur") {
			return emplacement.getDessin()[5][1];
		} else if(emplacement.getEtat().name() == "Mort") {
			return emplacement.getDessin()[6][1];
		} else {
			return null;
		}
		
	}

	public Vegetal getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Vegetal emplacement) {
		this.emplacement = emplacement;
	}
	
	
}
