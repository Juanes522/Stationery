package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.HashMap;

public class PurchaseDTO {

	private LocalDate purchaseDate;
	private HashMap<Integer, Integer> products;
	private double totalPay;

	public PurchaseDTO() {
	}

	public PurchaseDTO(LocalDate purchaseDate, double totalPay) {
		this.purchaseDate = purchaseDate;
		this.products = new HashMap<>();
		this.totalPay = totalPay;
	}

	public PurchaseDTO(LocalDate purchaseDate, HashMap<Integer, Integer> products, double totalPay) {
		this.purchaseDate = purchaseDate;
		this.products = products;
		this.totalPay = totalPay;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}

	public double getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}

}
