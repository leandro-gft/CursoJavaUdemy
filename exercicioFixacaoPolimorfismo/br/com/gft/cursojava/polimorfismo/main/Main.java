package br.com.gft.cursojava.polimorfismo.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.polimorfismo.entities.ImportedProduct;
import br.com.gft.cursojava.polimorfismo.entities.Product;
import br.com.gft.cursojava.polimorfismo.entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data");
			System.out.print("Common, used or imported (c/u/i): ");
			char res = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (res == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product imported = new ImportedProduct(name, price, customsFee);
				list.add(imported);
			} else if (res == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String manufactureDate = sc.nextLine();
				Product used = new UsedProduct(name, price, sdf.parse(manufactureDate));
				list.add(used);
			} else {
				Product common = new Product(name, price);
				list.add(common);
			}

		}

		System.out.println("");
		System.out.println("PRICE TAGS: ");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

	}

}
