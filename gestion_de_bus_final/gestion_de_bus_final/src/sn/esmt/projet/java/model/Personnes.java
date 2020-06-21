package sn.esmt.projet.java.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class Personnes implements IPersonne {

		

		private List<Personne> liste;

		public Personnes() {
			liste = new ArrayList<>();
		}

		public List<Personne> getListe() {
			return liste;
		}

		@Override
		public void sort() {
			Collections.sort(liste);
		}


	

		@Override
		public void sort(Comparator<Personne> comparator) {
			// TODO Auto-generated method stub
			Collections.sort(liste, comparator);
			
		}

		@Override
		public void update(Personne personne) {
			// TODO Auto-generated method stub
			delete(personne.getIdUser());
			add(personne);
			
		}

		@Override
		public void add(Personne personne) {
			// TODO Auto-generated method stub
			int position = Collections.binarySearch(liste, personne);
			liste.add(Math.abs(position) - 1, personne);
		}

		@Override
		public Personne find(int id) {
			// TODO Auto-generated method stub
			for (int i = 0 ; i < liste.size() ; i ++) {
				if (liste.get(i).getIdUser() == id) {
					return liste.get(i);
				}
			}
			return null;
		}

		@Override
		public Personne find(String nom) {
			// TODO Auto-generated method stub
			
			for (int i = 0 ; i < liste.size() ; i ++) {
				if (liste.get(i).getNom().equals(nom)) {
					return liste.get(i);
				}
			}

			return null;
		}

		@Override
		public void delete(int id) {
			// TODO Auto-generated method stub
			int position = Collections.binarySearch(liste, find(id));
			try {
				liste.remove(Math.abs(position));
			} catch (IndexOutOfBoundsException ignored) {}
		}

		
	public static int getUniqueId () throws Exception {
			
			Personnes personnes = new Personnes();
			List<Personne> liste = personnes.getListe();
			if (liste.isEmpty()) return 1;
			
			int maxId = Collections.max(liste).getIdUser();		
			return maxId + 1;
		}
		
	}

