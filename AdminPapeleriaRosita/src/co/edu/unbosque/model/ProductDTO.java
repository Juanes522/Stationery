package co.edu.unbosque.model;

/**
 * Esta clase representa un objeto DTO (Data Transfer Object) para un producto.
 * Un DTO se utiliza para transferir datos entre capas de una aplicación, y en
 * este caso contiene la información básica sobre un producto, como su nombre,
 * precio, costo, cantidad y el ID del proveedor asociado.
 * 
 * <p>
 * La clase incluye constructores, getters y setters para manipular los
 * atributos del producto, así como un método {@code toString()} para
 * representar el objeto como una cadena de texto.
 * </p>
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class ProductDTO {

	/** Nombre del producto */
	private String name;

	/** Precio de venta del producto */
	private double price;

	/** Costo del producto para la empresa */
	private double cost;

	/** Cantidad disponible del producto en inventario */
	private int quantity;

	/** ID del proveedor asociado con el producto */
	private int idSuplierPartner;

	/**
	 * Constructor de la clase ProductDTO que inicializa todos los atributos.
	 * 
	 * @param name             Nombre del producto.
	 * @param price            Precio de venta del producto.
	 * @param cost             Costo del producto para la empresa.
	 * @param quantity         Cantidad disponible del producto en inventario.
	 * @param idSuplierPartner ID del proveedor asociado con el producto.
	 */
	public ProductDTO(String name, double price, double cost, int quantity, int idSuplierPartner) {
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.quantity = quantity;
		this.idSuplierPartner = idSuplierPartner;
	}

	/**
	 * Obtiene el nombre del producto.
	 * 
	 * @return El nombre del producto.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del producto.
	 * 
	 * @param name El nombre que se desea asignar al producto.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el precio de venta del producto.
	 * 
	 * @return El precio de venta del producto.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Establece el precio de venta del producto.
	 * 
	 * @param price El precio que se desea asignar al producto.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Obtiene el costo del producto para la empresa.
	 * 
	 * @return El costo del producto.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Establece el costo del producto para la empresa.
	 * 
	 * @param cost El costo que se desea asignar al producto.
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Obtiene la cantidad disponible del producto en inventario.
	 * 
	 * @return La cantidad disponible del producto.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Establece la cantidad disponible del producto en inventario.
	 * 
	 * @param quantity La cantidad que se desea asignar al producto.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Obtiene el ID del proveedor asociado con el producto.
	 * 
	 * @return El ID del proveedor del producto.
	 */
	public int getIdSuplierPartner() {
		return idSuplierPartner;
	}

	/**
	 * Establece el ID del proveedor asociado con el producto.
	 * 
	 * @param idSuplierPartner El ID del proveedor que se desea asignar al producto.
	 */
	public void setIdSuplierPartner(int idSuplierPartner) {
		this.idSuplierPartner = idSuplierPartner;
	}

	/**
	 * Retorna una representación en formato cadena del objeto ProductDTO.
	 * 
	 * @return Una cadena que representa el objeto ProductDTO con sus atributos.
	 */
	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + ", cost=" + cost + ", quantity=" + quantity
				+ ", idSuplierPartner=" + idSuplierPartner + "]";
	}
}
