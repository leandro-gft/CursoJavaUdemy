package br.com.gft.cursojava.exerciciointerface.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.exerciciointerface.entities.CarRental;
import br.com.gft.cursojava.exerciciointerface.entities.Invoice;
import br.com.gft.cursojava.exerciciointerface.entities.Vehicle;
import br.com.gft.cursojava.exerciciointerface.services.BrazilTaxService;
import br.com.gft.cursojava.exerciciointerface.services.RentalService;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:ss");
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel) );
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(cr);
		System.out.println();
		System.out.println("INVOICE");
		System.out.println("Basic payment: "+cr.getInvoice().getBasicPayment());
		System.out.println("Tax: "+cr.getInvoice().getTax());
		System.out.println("Total payment: "+cr.getInvoice().getTotalPayment());

		sc.close();
		
	}
	
}

