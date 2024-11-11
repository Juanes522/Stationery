package co.edu.unbosque.model.persistence;

/**
 * Interfaz que define las operaciones básicas de persistencia de datos (CRUD)
 * para una entidad genérica. Esta interfaz proporciona métodos para crear,
 * actualizar y eliminar objetos de tipo {@code T}. Las clases que implementen
 * esta interfaz deben definir la lógica de persistencia específica para cada
 * tipo de objeto.
 * 
 * @param <T> Tipo genérico de los objetos que manejarán las operaciones de
 *            persistencia.
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public interface OperationsDAO<T> {

	/**
	 * Crea un nuevo objeto en la base de datos.
	 * 
	 * @param object El objeto a crear.
	 * @throws Exception Si ocurre un error durante la creación del objeto.
	 */
	void create(T object) throws Exception;

	/**
	 * Actualiza un objeto existente en la base de datos.
	 * 
	 * @param id     El identificador del objeto a actualizar.
	 * @param object El objeto con los nuevos valores a actualizar.
	 * @throws Exception Si ocurre un error durante la actualización del objeto.
	 */
	void update(int id, T object) throws Exception;

	/**
	 * Elimina un objeto de la base de datos.
	 * 
	 * @param id El identificador del objeto a eliminar.
	 * @throws Exception Si ocurre un error durante la eliminación del objeto.
	 */
	void delete(int id) throws Exception;
}
