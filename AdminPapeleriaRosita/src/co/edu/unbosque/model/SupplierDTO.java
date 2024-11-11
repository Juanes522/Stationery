package co.edu.unbosque.model;

/**
 * Esta clase representa un objeto DTO (Data Transfer Object) para un proveedor.
 * El DTO es utilizado para transferir datos relacionados con un proveedor, como
 * su nombre, dirección y número de teléfono.
 * 
 * <p>
 * La clase incluye constructores, getters y setters para acceder y modificar
 * los atributos del proveedor.
 * </p>
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class SupplierDTO {

	/** Nombre del proveedor */
	private String name;

	/** Dirección del proveedor */
	private String address;

	/** Teléfono del proveedor */
	private String phone;

	/**
	 * Constructor vacío de la clase SupplierDTO. Se utiliza para crear un objeto de
	 * proveedor sin inicializar los valores.
	 */
	public SupplierDTO() {
	}

	/**
	 * Constructor de la clase SupplierDTO que inicializa el nombre, la dirección y
	 * el teléfono del proveedor.
	 * 
	 * @param name    Nombre del proveedor.
	 * @param address Dirección del proveedor.
	 * @param phone   Teléfono del proveedor.
	 */
	public SupplierDTO(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	/**
	 * Obtiene el nombre del proveedor.
	 * 
	 * @return El nombre del proveedor.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del proveedor.
	 * 
	 * @param name El nombre que se desea asignar al proveedor.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la dirección del proveedor.
	 * 
	 * @return La dirección del proveedor.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Establece la dirección del proveedor.
	 * 
	 * @param address La dirección que se desea asignar al proveedor.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Obtiene el número de teléfono del proveedor.
	 * 
	 * @return El teléfono del proveedor.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Establece el número de teléfono del proveedor.
	 * 
	 * @param phone El número de teléfono que se desea asignar al proveedor.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Representa al proveedor como una cadena de texto.
	 * 
	 * @return Una cadena que contiene el nombre, la dirección y el teléfono del
	 *         proveedor.
	 */
	@Override
	public String toString() {
		return "SupplierDTO [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
}
