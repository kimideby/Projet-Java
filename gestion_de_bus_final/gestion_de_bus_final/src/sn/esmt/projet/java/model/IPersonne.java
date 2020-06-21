package sn.esmt.projet.java.model;

import java.util.Comparator;

public interface IPersonne {

	
		/**
		 * 
		 */
		public void sort ();
		/**
		 * @param comparator
		 */
		public void sort (Comparator<Personne> comparator);
		/**
		 * @param id
		 */
		public void delete (int id);
		/**
		 * @param contact
		 */
		public void update (Personne personne);
		/**
		 * @param contact
		 */
		public void add (Personne personne);
		/**
		 * @param id
		 * @return
		 */
		public Personne find (int id);
		/**
		 * @param nom
		 * @return
		 */
		public Personne find (String nom);
	}


