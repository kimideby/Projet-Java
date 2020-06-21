package sn.esmt.projet.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Users {
	
	
	private List<User> liste;

	public Users() {
		liste = new ArrayList<>();
	}

	public List<User> getListe() {
		return liste;
	}

	
	public void sort() {
		Collections.sort(liste);
	}



	public void sort(Comparator<User> comparator) {
		// TODO Auto-generated method stub
		Collections.sort(liste, comparator);
		
	}

	
	public void update(User user) {
		// TODO Auto-generated method stub
		delete(user.getId());
		add(user);
		
	}

	
	public void add(User user) {
		// TODO Auto-generated method stub
		int position = Collections.binarySearch(liste, user);
		liste.add(Math.abs(position) - 1, user);
	}

	
	public User find(int id) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < liste.size() ; i ++) {
			if (liste.get(i).getId() == id) {
				return liste.get(i);
			}
		}
		return null;
	}

	

	public void delete(int id) {
		// TODO Auto-generated method stub
		int position = Collections.binarySearch(liste, find(id));
		try {
			liste.remove(Math.abs(position));
		} catch (IndexOutOfBoundsException ignored) {}
	}

	
public static int getUniqueId () throws Exception {
		
		Users users = new Users();
		List<User> liste = users.getListe();
		if (liste.isEmpty()) return 1;
		
		int maxId = Collections.max(liste).getId();		
		return maxId + 1;
	}

}
