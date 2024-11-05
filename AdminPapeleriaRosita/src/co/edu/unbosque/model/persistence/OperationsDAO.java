package co.edu.unbosque.model.persistence;

public interface OperationsDAO<T> {
	
	void create(T object)throws Exception;
	void update(int id, T object) throws Exception;
	void delete(int id) throws Exception;

}
