package br.com.gft.cursojava.exerciciom13.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus	status;
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);		
	}
	
	public Double total() {
		Double sum = 0.0;
		for (OrderItem orderItem : items) {
			sum += orderItem.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: ");
		sb.append(sdf.format(new Date())+"\n");		
		sb.append("Order status: ");
		sb.append(status+"\n");
		sb.append("Client: ");
		sb.append(client.getName()+"("+sdf2.format(client.getBirthDate())+") - ");
		sb.append(client.getEmail()+"\n");
		sb.append("Order items:\n");
		for (OrderItem orderItem : items) {
			sb.append(orderItem.getProduct().getName()+", ");
			sb.append(orderItem.getPrice()+", ");
			sb.append("Quantity: ");
			sb.append(orderItem.getQuantity()+", ");
			sb.append("Subtotal: ");
			sb.append(orderItem.subTotal()+"\n");
		}		
		sb.append("Total price: ");
		sb.append(total());
		return sb.toString();
			
	}

}
