package br.com.gft.cursojava.fixacaolambda.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.gft.cursojava.fixacaolambda.entitites.Employee;
import br.com.gft.cursojava.lambda.entities.Products;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file path: ");
		
		try (BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
			System.out.print("Enter salary: ");
			Double baseSalary = sc.nextDouble();

			List<Employee> list = new ArrayList<>();
			
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				itemCsv = br.readLine();
			}
			List<String> emails = list.stream()
					.filter(p -> p.getSalary() > baseSalary)
					.map(p -> p.getEmail())
					.sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase()))
					.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than "+baseSalary+": ");
			emails.forEach(System.out::println);
			
			Double sum = list.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.0, (x, y) -> x+y);
		
			System.out.printf("Sum of salary of people whose name starts whith 'M':  %.2f%n" ,sum);
			
		}

		catch (IOException e) {
			System.out.println("ERROR MESSAGE: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("ERROR MESSAGE: " + e.getMessage());
		}

		sc.close();

	}

}
