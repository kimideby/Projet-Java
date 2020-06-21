package sn.esmt.projet.java.model;

import java.util.List;

public interface IDaoUser<T> {

	
	public void deleteUser (int id) throws Exception;
	public  void createUser(T entity) throws Exception;
	public List<User> listeUser () throws Exception; 
}
