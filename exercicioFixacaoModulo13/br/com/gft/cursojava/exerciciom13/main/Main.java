package br.com.gft.cursojava.exerciciom13.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.exerciciom13.entities.Product;
import br.com.gft.cursojava.exerciciom13.entities.Client;
import br.com.gft.cursojava.exerciciom13.entities.Order;
import br.com.gft.cursojava.exerciciom13.entities.OrderItem;
import br.com.gft.cursojava.exerciciom13.entities.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		Client client = new Client(clientName, email, birthDate);
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = null;
		status = OrderStatus.valueOf(sc.nextLine());
		Order order = new Order(new Date(), status, client);
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i <=n; i++) {
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity, price, new Product(productName, price));
			order.addItem(item);		
		}
		
		System.out.println(order);
		
		sc.close();		
		
	}

}
