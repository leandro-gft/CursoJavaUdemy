package br.com.gft.cursojava.exercicioenum.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}
	
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<HourContract> getContracts() {
		return contracts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(Integer month, Integer year) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (HourContract hourContract : contracts) {
			cal.setTime(hourContract.getDate());
			if (month == (1 + cal.get(Calendar.MONTH)) && year == cal.get(Calendar.YEAR)) { //mes come�a em 0, portanto soma mais 1
				sum += hourContract.totalValue();				
			}
		}
		return sum;
		
	}

}
