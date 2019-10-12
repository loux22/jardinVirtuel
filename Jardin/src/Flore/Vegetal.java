package Flore;

import Etat.Etat;

public abstract class Vegetal {
	private Etat etat;
	private String[][] dessin;
	
	public Vegetal(String en_feuille, String en_fleur) {
		dessin = new String[7][2];
		this.etat = Etat.Graine;
		dessin[0][0] = "État du végetal";
		dessin[0][1] = "Dessin";
		dessin[1][0] = "En graine";
		dessin[1][1] = "_";
		dessin[2][0] = "En germe";
		dessin[2][1] = ".";
		dessin[3][0] = "En tige";
		dessin[3][1] = "|";
		dessin[4][0] = "En feuille";
		dessin[4][1] = en_feuille;
		dessin[5][0] = "En fleur";
		dessin[5][1] = en_fleur;
		dessin[6][0] = "Mort";
		dessin[6][1] = "#";
		
		for(int i = 0; i < dessin.length; i++) {
			System.out.println(dessin[i][0] + " : " + dessin[i][1]);
		}
	}
	
	
	public void grandir() {
		this.etat = Etat.values()[this.etat.ordinal() + 1];
	}
	
	
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String[][] getDessin() {
		return dessin;
	}

	public void setDessin(String[][] dessin) {
		this.dessin = dessin;
	}
	
}
