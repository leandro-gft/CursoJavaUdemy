package br.com.gft.cursojava.exficacaointerface.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.exficacaointerface.entities.Contract;
import br.com.gft.cursojava.exficacaointerface.entities.Installment;
import br.com.gft.cursojava.exficacaointerface.service.ContractService;
import br.com.gft.cursojava.exficacaointerface.service.PaypalService;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		Contract contract = new Contract(number, date, totalValue);
		System.out.print("Enter number of installments: ");
		Integer months = sc.nextInt();
		

		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, months);
		
		System.out.println("Installments: ");
			for (Installment x : contract.getInstallments()) {
				System.out.println(x);
			}
		
		
		
		sc.close();
	}
	
	
}
