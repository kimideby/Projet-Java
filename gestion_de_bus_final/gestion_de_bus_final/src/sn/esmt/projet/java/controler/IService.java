package sn.esmt.projet.java.controler;

import java.util.List;



public interface IService<T> {

	public  void create (T entity) throws Exception; 
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<T> liste () throws Exception; 
	/**
	 * 
	 * @param entity
	 * @throws DAOException
	 * @throws ContactManagerException
	 */
	public void update (T entity) throws Exception;
	/**
	 * 
	 * @param id
	 * @throws DAOException
	 */
	public void delete (int id) throws Exception;
	/**
	 * 
	 * @param <C>
	 * @param critere
	 * @return
	 * @throws DAOException
	 */
	public  <C> T search(C critere) throws Exception;
}
