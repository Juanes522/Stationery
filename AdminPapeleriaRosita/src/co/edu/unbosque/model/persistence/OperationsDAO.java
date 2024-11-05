package co.edu.unbosque.model.persistence;

public interface OperationsDAO<T> {
	
	int create(T object) ;
	int update(int id, T object);
	int delete(int id);

}
