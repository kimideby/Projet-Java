package sn.esmt.projet.java.model;

import java.util.List;

public interface IDaoChauffeur<T> {
	public  void createChauf (T entity) throws Exception; 
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<T> listeChauf () throws Exception; 
	/**
	 * 
	 * @param entity
	 * @throws DAOException
	 * @throws ContactManagerException
	 */
	public void updateChauf (T entity) throws Exception;
	/**
	 * 
	 * @param id
	 * @throws DAOException
	 */
	public void deleteChauf (int id) throws Exception;
	/**
	 * 
	 * @param <C>
	 * @param critere
	 * @return
	 * @throws DAOException
	 */
	public  <C> T searchChauf(C critere) throws Exception;

}
