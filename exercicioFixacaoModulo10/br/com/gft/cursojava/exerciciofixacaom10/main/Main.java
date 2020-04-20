package br.com.gft.cursojava.exerciciofixacaom10.main;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.exerciciofixacaom10.entities.Rent;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.print("How many rooms will be rented? ");
		System.out.println("");
		int n = sc.nextInt();
		Rent[] vect = new Rent[10];

		for (int i = 0; i<n; i++) {
			sc.nextLine();
			System.out.println("Rent #"+(i+1));
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			System.out.println("");
			vect[room] = new Rent(name, email);
		}
	
		System.out.println("");
		System.out.println("Busy rooms:");
		for (int i = 0; i<vect.length; i++) {
			if (vect[i] != null) {
			System.out.println(i+": "+vect[i].getName()+", "+vect[i].getEmail());
			}
		}	
		
		sc.close();
	
	}
}
