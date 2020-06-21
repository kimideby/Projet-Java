package sn.esmt.projet.java.model;

import java.util.List;

public interface IDaoBus<T> {
	

	public  void createBus (T entity) throws Exception; 
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<T> listeBus () throws Exception; 
	/**
	 * 
	 * @param entity
	 * @throws DAOException
	 * @throws ContactManagerException
	 */
	public void updateBus (T entity) throws Exception;
	/**
	 * 
	 * @param id
	 * @throws DAOException
	 */
	public void deleteBus (int id) throws Exception;
	/**
	 * 
	 * @param <C>
	 * @param critere
	 * @return
	 * @throws DAOException
	 */
	public  <C> T searchBus(C critere) throws Exception;

}
