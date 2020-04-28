package br.com.gft.cursojava.lambda.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.gft.cursojava.lambda.entities.Products;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		List<Products> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				list.add(new Products(name, price));
				itemCsv = br.readLine();
			}
			
			Double avrPrc = list.stream()
					.map(p -> p.getPrice())
					.reduce(0.0, (x, y) -> x+y)/list.size();
		
			System.out.printf("Average price: %.2f%n" ,avrPrc);
			
		//	Comparator <String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream()
					.filter(p -> p.getPrice() < avrPrc)
					.map(p -> p.getName())
					.sorted((s1, s2) -> -s1.toUpperCase().compareTo(s2.toUpperCase()))
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);

		}

		catch (IOException e) {
			System.out.println("ERROR MESSAGE: " + e.getMessage());
		}

		sc.close();

	}

}
