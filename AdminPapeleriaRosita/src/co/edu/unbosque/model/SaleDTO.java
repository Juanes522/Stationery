package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Esta clase representa un objeto DTO (Data Transfer Object) para una venta. El
 * DTO es utilizado para transferir datos relacionados con una venta, como la
 * fecha de la venta, los productos involucrados, el vendedor y el monto total
 * pagado.
 * 
 * <p>
 * La clase incluye constructores, getters y setters para acceder y modificar
 * los atributos de la venta.
 * </p>
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class SaleDTO {

	/** Fecha en la que se realizó la venta */
	private LocalDate saleDate;

	/**
	 * Mapa de productos con su respectiva cantidad en la venta (clave: ID del
	 * producto, valor: cantidad vendida)
	 */
	private HashMap<Integer, Integer> products;

	/** Vendedor que realizó la venta */
	private String seller;

	/** Total pagado por la venta */
	private double totalPay;

	/**
	 * Constructor vacío de la clase SaleDTO. Se utiliza para crear un objeto de
	 * venta sin inicializar los valores.
	 */
	public SaleDTO() {
	}

	/**
	 * Constructor de la clase SaleDTO que inicializa la fecha de la venta, el
	 * vendedor y el monto total.
	 * 
	 * @param saleDate Fecha en la que se realizó la venta.
	 * @param seller   Nombre del vendedor que realizó la venta.
	 * @param totalPay Monto total pagado por la venta.
	 */
	public SaleDTO(LocalDate saleDate, String seller, double totalPay) {
		this.saleDate = saleDate;
		this.products = new HashMap<>();
		this.seller = seller;
		this.totalPay = totalPay;
	}

	/**
	 * Constructor de la clase SaleDTO que inicializa la fecha de la venta, los
	 * productos involucrados, el vendedor y el monto total.
	 * 
	 * @param saleDate Fecha en la que se realizó la venta.
	 * @param products Mapa de productos y cantidades asociados a la venta.
	 * @param seller   Nombre del vendedor que realizó la venta.
	 * @param totalPay Monto total pagado por la venta.
	 */
	public SaleDTO(LocalDate saleDate, HashMap<Integer, Integer> products, String seller, double totalPay) {
		this.saleDate = saleDate;
		this.products = products;
		this.seller = seller;
		this.totalPay = totalPay;
	}

	/**
	 * Obtiene la fecha en la que se realizó la venta.
	 * 
	 * @return La fecha de la venta.
	 */
	public LocalDate getSaleDate() {
		return saleDate;
	}

	/**
	 * Establece la fecha en la que se realizó la venta.
	 * 
	 * @param saleDate La fecha que se desea asignar a la venta.
	 */
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	/**
	 * Obtiene el mapa de productos y sus cantidades asociadas a la venta.
	 * 
	 * @return Un mapa con el ID de los productos como clave y la cantidad vendida
	 *         como valor.
	 */
	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	/**
	 * Establece el mapa de productos y cantidades asociadas a la venta.
	 * 
	 * @param products El mapa de productos y cantidades a asignar a la venta.
	 */
	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}

	/**
	 * Obtiene el monto total pagado por la venta.
	 * 
	 * @return El monto total pagado.
	 */
	public double getTotalPay() {
		return totalPay;
	}

	/**
	 * Establece el monto total pagado por la venta.
	 * 
	 * @param totalPay El monto total a asignar a la venta.
	 */
	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}

	/**
	 * Obtiene el nombre del vendedor que realizó la venta.
	 * 
	 * @return El nombre del vendedor.
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * Establece el nombre del vendedor que realizó la venta.
	 * 
	 * @param seller El nombre del vendedor a asignar.
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}

}
