package br.com.gft.cursojava.exercicionotas.main;

import java.util.Locale;
import java.util.Scanner;

import br.com.gft.cursojava.exercicionotas.entities.Student;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Student name: ");
		student.nome = sc.nextLine();
		System.out.print("Grade T1: ");
		student.grade.t1 = sc.nextDouble();
		System.out.print("Grade T2: ");
		student.grade.t2 = sc.nextDouble();
		System.out.print("Grade T3: ");
		student.grade.t3 = sc.nextDouble();
		
		student.grade.situation();	
		sc.close();
		
	}
}
