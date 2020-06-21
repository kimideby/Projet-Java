package sn.esmt.projet.java.model;

import java.util.List;

public interface IDaoTrajet<T> {


	public  void createTra (T entity) throws Exception; 
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<T> listeTra () throws Exception; 
	/**
	 * 
	 * @param entity
	 * @throws DAOException
	 * @throws ContactManagerException
	 */

	/**
	 * 
	 * @param id
	 * @throws DAOException
	 */
	public void deleteTra (int id) throws Exception;
	/**
	 * 
	 * @param <C>
	 * @param critere
	 * @return
	 * @throws DAOException
	 */
}
