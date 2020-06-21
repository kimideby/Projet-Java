package sn.esmt.projet.java.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class DAOList {

	
	public List<User> listeUser() throws SQLException, Exception {
		try (Connection connection = DBConnexion.getConnection()) {
			java.sql.Statement statement = connection.createStatement(); 
			String query = "Select * user";
		ResultSet resultSet = statement.executeQuery(query);
		List<User> contacts = new ArrayList<>();
		while (resultSet.next()) { 
			int identifiant = resultSet.getInt("id"); 
			String nom = resultSet.getString("login"); 
			String prenom = resultSet.getString("password"); 
			String email = resultSet.getString("role");
			User contact = new User (nom, prenom, email); 
			contact.setId(identifiant); 
			contacts.add(contact);
		}
		return contacts;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
	
}
