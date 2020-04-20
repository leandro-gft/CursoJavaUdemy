package br.com.cursojava.exerciciofixacaom9.main;

import java.util.Locale;
import java.util.Scanner;

import br.com.cursojava.exerciciofixacaom9.entities.Holder;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Holder holder = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account number: ");
		int accountNumber = (sc.nextInt());
		System.out.print("Enter account holder: ");
		sc.nextLine();
		String accountHolder = sc.nextLine();
		System.out.print("Is there an initial deposit (y/n)? ");
		char response = sc.next().toLowerCase().charAt(0);

		if (response == 'y') {
			System.out.println("Enter initial deposit value: ");
			double deposit = sc.nextDouble();
			holder = new Holder(accountNumber, accountHolder, deposit);
		} else if (response == 'n') {
			holder = new Holder(accountNumber, accountHolder);
		}
		System.out.println("");
		System.out.println("Account data: ");
		System.out.println(holder);
		
		System.out.println("");
		System.out.print("Enter a deposit value: ");
		holder.deposit(sc.nextDouble());
		System.out.println("Updated account data: ");
		System.out.println(holder);
		System.out.println("");

		System.out.print("Enter a withdraw value: ");
		holder.withdraw(sc.nextDouble());
		System.out.println("Updated account data: ");
		System.out.println(holder);

		sc.close();
	}

}
