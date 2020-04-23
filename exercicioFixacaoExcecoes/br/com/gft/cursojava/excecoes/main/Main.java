package br.com.gft.cursojava.excecoes.main;

import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.excecoes.model.entities.Account;
import br.com.gft.cursojava.excecoes.model.exceptions.DomainException;

public class Main {
	public static void main(String[] args) {
		
		try {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		System.out.println("New balance: "+account.withdraw(amount));
		
		sc.close();	
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: "+e.getMessage());			
		}
		catch (RuntimeException e) {
			System.out.println("Unknown Error");
		}
	}

}
