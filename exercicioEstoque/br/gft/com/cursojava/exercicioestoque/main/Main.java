package br.gft.com.cursojava.exercicioestoque.main;

import java.util.Locale;
import java.util.Scanner;

import br.gft.com.cursojava.exercicioestoque.entities.Product;

public class Main {
	public static void main(String[] args) {

		Product product = new Product();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product data: ");
		System.out.print("Name: ");
		product.setName(sc.nextLine());
		System.out.print("Price: ");
		product.setPrice(sc.nextDouble());
		System.out.print("Quantity in stock: ");
		product.AddProducts(sc.nextInt());
		System.out.println("Product data: " + product);
		System.out.println("Enter the number of products to be added in stock: ");
		product.AddProducts(sc.nextInt());
		System.out.println("Updated data: " + product);
		System.out.println("Enter the number of products to be removed in stock: ");
		product.RemoveProducts(sc.nextInt());
		System.out.println("Updated data: " + product);
		sc.close();

	}
}
