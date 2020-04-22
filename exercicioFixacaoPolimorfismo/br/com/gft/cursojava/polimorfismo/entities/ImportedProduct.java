package br.com.gft.cursojava.polimorfismo.entities;

public class ImportedProduct extends Product {
	
	private Double customsFee;
	
	public ImportedProduct() {
		
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return price+customsFee;
	}
	
	@Override
	public String priceTag() {
		super.priceTag();
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" $ ");
		sb.append(totalPrice());
		sb.append(" (Customs Fee: $ ");
		sb.append(customsFee+ ")");
		return sb.toString();
	}

}
