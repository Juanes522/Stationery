package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Esta clase representa un objeto DTO (Data Transfer Object) para una compra.
 * El DTO es utilizado para transferir datos relacionados con una compra, como
 * la fecha de la compra, los productos involucrados y el monto total pagado.
 * 
 * <p>
 * La clase incluye constructores, getters y setters para acceder y modificar
 * los atributos de la compra.
 * </p>
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class PurchaseDTO {

	/** Fecha en la que se realizó la compra */
	private LocalDate purchaseDate;

	/**
	 * Mapa de productos con su respectiva cantidad en la compra (clave: ID del
	 * producto, valor: cantidad comprada)
	 */
	private HashMap<Integer, Integer> products;

	/** Total pagado por la compra */
	private double totalPay;

	/**
	 * Constructor vacío de la clase PurchaseDTO. Se utiliza para crear un objeto de
	 * compra sin inicializar los valores.
	 */
	public PurchaseDTO() {
	}

	/**
	 * Constructor de la clase PurchaseDTO que inicializa la fecha de la compra y el
	 * monto total.
	 * 
	 * @param purchaseDate Fecha en la que se realizó la compra.
	 * @param totalPay     Monto total pagado por la compra.
	 */
	public PurchaseDTO(LocalDate purchaseDate, double totalPay) {
		this.purchaseDate = purchaseDate;
		this.products = new HashMap<>();
		this.totalPay = totalPay;
	}

	/**
	 * Constructor de la clase PurchaseDTO que inicializa la fecha de la compra, los
	 * productos involucrados y el monto total.
	 * 
	 * @param purchaseDate Fecha en la que se realizó la compra.
	 * @param products     Mapa de productos y cantidades asociados a la compra.
	 * @param totalPay     Monto total pagado por la compra.
	 */
	public PurchaseDTO(LocalDate purchaseDate, HashMap<Integer, Integer> products, double totalPay) {
		this.purchaseDate = purchaseDate;
		this.products = products;
		this.totalPay = totalPay;
	}

	/**
	 * Obtiene la fecha en la que se realizó la compra.
	 * 
	 * @return La fecha de la compra.
	 */
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Establece la fecha en la que se realizó la compra.
	 * 
	 * @param purchaseDate La fecha que se desea asignar a la compra.
	 */
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Obtiene el mapa de productos y sus cantidades asociadas a la compra.
	 * 
	 * @return Un mapa con el ID de los productos como clave y la cantidad comprada
	 *         como valor.
	 */
	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	/**
	 * Establece el mapa de productos y cantidades asociadas a la compra.
	 * 
	 * @param products El mapa de productos y cantidades a asignar a la compra.
	 */
	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}

	/**
	 * Obtiene el monto total pagado por la compra.
	 * 
	 * @return El monto total pagado.
	 */
	public double getTotalPay() {
		return totalPay;
	}

	/**
	 * Establece el monto total pagado por la compra.
	 * 
	 * @param totalPay El monto total a asignar a la compra.
	 */
	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}

}
