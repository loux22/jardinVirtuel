package main;

import java.util.Scanner;

import Flore.Ail;
import Flore.Tomate;
import Flore.Vegetal;

public class Terre {

	public static void main(String[] args) {
		int longueur = 5;
		int largeur = 3;
		Jardin j = new Jardin(longueur, largeur);
		
		for (int i = 0; i < 100; i++) {
		j.toString();
		System.out.println("1. Semer une graine");
		System.out.println("2. Récolter toutes les plantes qui sont mature");
		System.out.println("3. Passer à la saison suivante");
		System.out.println("4. Quitter l'application");
		
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		
		if (res == 1) {
			j.semer();
		} else if(res == 2) {
			 j.recolter();	 
		} else if(res == 3) {
			j.saisonSuivante();
		}
		}
	}
}
