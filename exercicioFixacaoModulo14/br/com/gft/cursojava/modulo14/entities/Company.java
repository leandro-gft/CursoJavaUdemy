package br.com.gft.cursojava.modulo14.entities;

public class Company extends Payer{
	
	private Integer numberEmp;
	
	public Company() {
		
	}

	public Company(String name, Double anualIncome, Integer numberEmp) {
		super(name, anualIncome);
		this.numberEmp = numberEmp;
	}

	public Integer getNumberEmp() {
		return numberEmp;
	}

	public void setNumberEmp(Integer numberEmp) {
		this.numberEmp = numberEmp;
	}

	@Override
	public Double tax() {
		if (numberEmp < 10) {
			return 0.16*getAnualIncome();
		} 
		return 0.14*getAnualIncome();
	}
		
}
