package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.HashMap;

public class SaleDTO {
	
	private LocalDate saleDate; 
	private HashMap<Integer,Integer> products;
	private String seller;
	private double totalPay;
	
	public SaleDTO() {}
	
	public SaleDTO(LocalDate saleDate,String seller, double totalPay) {
		this.saleDate = saleDate;
		this.products = new HashMap<>();
		this.seller=seller;
		this.totalPay = totalPay;
	}

	public SaleDTO(LocalDate saleDate, HashMap<Integer, Integer> products, String seller, double totalPay) {
		this.saleDate = saleDate;
		this.products = products;
		this.seller = seller;
		this.totalPay = totalPay;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}
