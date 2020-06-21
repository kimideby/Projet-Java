package sn.esmt.projet.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDAO implements IDaoUser<User> {

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try (Connection connection = DBConnexion.getConnection()) { 
					PreparedStatement preparedStatement = connection. prepareStatement("Delete From user where id = ?"); 
					preparedStatement.setInt(1, id); 
					preparedStatement.executeUpdate(); 
				}
				catch (Exception e) { 
						throw new DAOException(e.getMessage()); 
				}
		
	}

	@Override
	public void createUser(User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listeUser() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
