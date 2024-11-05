package co.edu.unbosque.model;

public class ProductDTO {
	
	private String name;
	private double price;
	private double cost;
	private int  quantity;
	private int idSuplierPartner;
	
	public ProductDTO(String name, double price, double cost, int quantity, int idSuplierPartner) {
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.quantity = quantity;
		this.idSuplierPartner = idSuplierPartner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIdSuplierPartner() {
		return idSuplierPartner;
	}

	public void setIdSuplierPartner(int idSuplierPartner) {
		this.idSuplierPartner = idSuplierPartner;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", pice=" + price + ", cost=" + cost
				+ ", quantity=" + quantity + ", idSuplierPartner=" + idSuplierPartner + "]";
	}
	
	

}
