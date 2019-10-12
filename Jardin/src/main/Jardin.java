package main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

import Etat.Etat;
import Flore.Ail;
import Flore.Bettrave;
import Flore.Carotte;
import Flore.IOgm;
import Flore.IRacePure;
import Flore.Tomate;
import Flore.Vegetal;

public class Jardin {
	private int longueur;
	private int largeur;
	private Emplacement emplacement[][];
	private HashMap<String, Integer> panier;
	
	public Jardin(int longueur, int largeur) {
		this.largeur = largeur;
		this.longueur = longueur;
		this.panier = new HashMap<String, Integer>();
		emplacement = new Emplacement[longueur][largeur];
		ajoutPanier("Ail",5);
		ajoutPanier("Bettrave",10);
		ajoutPanier("Carotte",10);
		ajoutPanier("Tomate",10);
	}


	public void ajoutPanier(String nom_vegetal, int nombre_graines) {
		this.panier.put(nom_vegetal, nombre_graines);
		return;
	}
	
	public void semer() {
		System.out.println("Quel graine veux tu planter ?");
		System.out.println("1. Ail");
		System.out.println("2. Tomate");
		System.out.println("3. Carotte");
		System.out.println("4. Bettrave");
		
		Scanner choix_graine = new Scanner(System.in);
		int choix = choix_graine.nextInt();
		
		
		System.out.println("Ou souhaite tu placer ta graine ?");
		System.out.println("Y");
		Scanner semery = new Scanner(System.in);
		int y = semery.nextInt();
		System.out.println("X");
		Scanner semerx = new Scanner(System.in);
		int x = semerx.nextInt();
		
		
		if(choix == 1) {
			this.emplacement[x][y] = new Emplacement(new Ail()); 
			this.panier.put("Ail",panier.get("Ail") - 1);
		} else if(choix == 2){
			this.emplacement[x][y] = new Emplacement(new Tomate()); 
			this.panier.put("Tomate",panier.get("Tomate") - 1);
		} else if(choix == 3){
			this.emplacement[x][y] = new Emplacement(new Carotte()); 
			this.panier.put("Carotte",panier.get("Carotte") - 1);
		} else if(choix == 4){
			this.emplacement[x][y] = new Emplacement(new Bettrave());
			this.panier.put("Bettrave",panier.get("Bettrave") - 1);
		}
		return;
	}
	
	public void saisonSuivante() {
		for (int j = 0; j < largeur; j++) {
			for(int i = 0; i < longueur; i++) {
				if(emplacement[i][j] != null) {
					this.emplacement[i][j].getEmplacement().grandir();
				}
			}
		}
		
	}
	
	public void recolter() {
		
		for(int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				if((this.emplacement[i][j] != null) && (this.emplacement[i][j].getEmplacement().getEtat().name() == "Fleur")) {
					if(emplacement[i][j].getEmplacement() instanceof IRacePure) {
						IRacePure v = (IRacePure) emplacement[i][j].getEmplacement();
						v.seReproduire(this.panier);
					}
					this.emplacement[i][j] = null;
					if(emplacement[i][j].getEmplacement() instanceof IOgm) {
						IOgm v = (IOgm) emplacement[i][j].getEmplacement();
						int x = (int)(Math.random() * longueur);
						int y = (int)(Math.random() * largeur);
						SimpleEntry<Integer, Integer> entry = v.seDupliquer(x, y);
						if(this.emplacement[entry.getKey()][entry.getValue()] == null) {
						this.emplacement[entry.getKey()][entry.getValue()] = new Emplacement(new Bettrave());
						this.panier.put("Bettrave",panier.get("Bettrave") - 1);
						}
					}
				}
			}
		}
	}
	
	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public Emplacement[][] getEmplacement() {
		return emplacement;
	}


	public void setEmplacement(Emplacement[][] emplacement) {
		this.emplacement = emplacement;
	}


	public HashMap<String, Integer> getPanier() {
		return panier;
	}

	public void setPanier(HashMap<String, Integer> panier) {
		this.panier = panier;
	}
	@Override
	public String toString() {
		System.out.println("Voici notre jardin :");
		for (int j = 0; j < largeur; j++) {
			System.out.println();
			for(int i = 0; i < longueur; i++) {
				if(emplacement[i][j] == null) {
					System.out.print("o");
				} else {
					System.out.print(emplacement[i][j].toString());
				}
				
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("et notre panier contient  :");
		for (String x : panier.keySet()){
            System.out.println( x +" "+ panier.get(x)+" graine(s)");
          }
		System.out.println();
		return null;
	}
	
}

