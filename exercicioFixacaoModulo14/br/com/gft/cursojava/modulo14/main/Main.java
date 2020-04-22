package br.com.gft.cursojava.modulo14.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.modulo14.entities.Company;
import br.com.gft.cursojava.modulo14.entities.Individual;
import br.com.gft.cursojava.modulo14.entities.Payer;

public class Main {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Payer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i = 1; i <=n; i++) {
			System.out.println("Tax payer #"+i+" data:");
			System.out.print("Individual or company1 (i/c)? ");
			char res = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			if (res == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExp = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExp));				
			} else {
				System.out.print("Number of employees: ");
				int numberEmp = sc.nextInt();
				list.add(new Company(name, anualIncome, numberEmp));
			}			
		}
		System.out.println();
		System.out.println("TAXES PAID: ");
		Double sum = 0.0;
		for (Payer payer : list) {
			System.out.println(payer.getName()+": $ "+payer.tax());
			sum += payer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ "+sum);
		
	}
}
