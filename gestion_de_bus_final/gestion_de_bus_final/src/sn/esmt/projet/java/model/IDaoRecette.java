package sn.esmt.projet.java.model;

import java.util.List;

public interface IDaoRecette<T> {
	
	public List<T> listeRecette() throws DAOException;

}
