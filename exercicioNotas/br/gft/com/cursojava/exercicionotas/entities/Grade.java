package br.gft.com.cursojava.exercicionotas.entities;

public class Grade {
	
	public double t1, t2, t3;
	
	public double calcFinalGrade() {
		return t1+t2+t3;
	}
	
	public double missingPoints() {
		return 60.0-calcFinalGrade();
	}
	
	public void situation() {
		System.out.println("FINAL GRADE = "+calcFinalGrade());
		if (calcFinalGrade() >=60.0) {
			System.out.println("PASS");
		} else {
			System.out.println("FAILED");
			System.out.println("MISSING "+missingPoints()+" POINTS");
		}
	}

	

}
