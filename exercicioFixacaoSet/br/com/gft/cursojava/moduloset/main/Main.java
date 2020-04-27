package br.com.gft.cursojava.moduloset.main;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		
		System.out.print("How many students for course A: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			set.add(a);
		}

		System.out.print("How many students for course B: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int b = sc.nextInt();
			set.add(b);
		}

		System.out.print("How many students for course C: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int c = sc.nextInt();
			set.add(c);
		}
		System.out.println("Total students: "+set.size());
		
		sc.close();
	}

}
