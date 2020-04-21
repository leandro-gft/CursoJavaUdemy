package br.com.gft.cursojava.exercicioenum.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.exercicioenum.entities.Department;
import br.com.gft.cursojava.exercicioenum.entities.HourContract;
import br.com.gft.cursojava.exercicioenum.entities.Worker;
import br.com.gft.cursojava.exercicioenum.entities.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		Department dep = new Department(sc.nextLine());
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		WorkerLevel level = null;
		level = level.valueOf(sc.nextLine());
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, level, baseSalary, dep);
		System.out.println("");
		System.out.print("How many contracts to " + worker.getName() + ": ");
		Integer n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			HourContract hourContract = new HourContract(date, valuePerHour, hours);
			worker.addContract(hourContract);
			System.out.println("");
		}

		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Date date = sdf.parse(sc.nextLine());
		cal.setTime(date);
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + sdf.format(date) + ": "+worker.income((1+cal.get(Calendar.MONTH)),cal.get(Calendar.YEAR)));

	}
}
