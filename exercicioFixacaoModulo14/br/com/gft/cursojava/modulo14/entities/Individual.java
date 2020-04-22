package br.com.gft.cursojava.modulo14.entities;

public class Individual extends Payer{

	private Double healthExp;
	
	public Individual() {
		
	}

	public Individual(String name, Double anualIncome, Double healthExp) {
		super(name, anualIncome);
		this.healthExp = healthExp;
	}

	public Double getHealthExp() {
		return healthExp;
	}

	public void setHealthExp(Double healthExp) {
		this.healthExp = healthExp;
	}

	@Override
	public Double tax() {
		if (getAnualIncome() < 20000) {
			return 0.15*getAnualIncome()-0.5*healthExp;
		} 
		return 0.25*getAnualIncome()-0.5*healthExp;

	}
	
	
}
