package sn.esmt.projet.java.model;

import java.sql.Connection; 
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;






public class AdminUserDao implements IDaoBus<Bus>,IDaoChauffeur<Chauffeur>,IDaoUser<User>,IDaoTrajet<Trajet>, IDaoRecette<Recette> {	
	public void createUser(User entity) throws Exception {
		// TODO Auto-generated method stub
try (Connection connexion = DBConnexion.getConnection()) { 
			
			PreparedStatement preparedStatement = connexion.prepareStatement("Insert into user (login,password,role) values (?,?,?)");
	
			preparedStatement.setString(1, entity.getLogin()); 
			preparedStatement.setString(2, entity.getPassword()); 
			preparedStatement.setString(3, entity.getRole());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) { 
			throw new DAOException(e.getMessage()); 
		}
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		
		try (Connection connection = DBConnexion.getConnection()) { 
			PreparedStatement preparedStatement = connection. prepareStatement("Delete From user where id = ?"); 
			preparedStatement.setInt(1, id); 
			preparedStatement.executeUpdate(); 
			} catch (Exception e) { 
				throw new DAOException(e.getMessage()); 
				}
		
	}
	
	
	@Override
	public List<User> listeUser() throws DAOException {
		try (Connection connection = DBConnexion.getConnection()) {
			java.sql.Statement statement = connection.createStatement(); 
			String query = "Select * from user";
		ResultSet resultSet = statement.executeQuery(query);
		List<User> list = new ArrayList<>();
		while (resultSet.next()) { 
			int identifiant = resultSet.getInt("idUser"); 
			String login = resultSet.getString("login"); 
			String pwd = resultSet.getString("password"); 
			String roleU = resultSet.getString("role");
			User user = new User (login, pwd, roleU); 
			user.setId(identifiant); 
			list.add(user);
		}
		return list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}	
	}

	@Override
	public void createBus(Bus entity) throws Exception {
		
		try (Connection connexion = DBConnexion.getConnection()) { 
			
			PreparedStatement preparedStatement = connexion.prepareStatement("Insert into bus (id_trajet,matriculation,ligne_bus,nom_parking,etat_bus) values (?,?,?,?,?)");
			
			preparedStatement.setInt(1, entity.getTrajet().getIdTrajet());
			preparedStatement.setString(2, entity.getMatriculation());
			preparedStatement.setString(3, entity.getLigneBus()); 
			preparedStatement.setString(4, entity.getNomParcking());
			preparedStatement.setString(5, entity.getEtatDuBus());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) { 
			throw new DAOException(e.getMessage()); 
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bus> listeBus() throws Exception {
		
		try (Connection connection = DBConnexion.getConnection()) {
			java.sql.Statement statement = connection.createStatement(); 
			String query = "Select * From bus,trajet where bus.id_trajet = trajet.id_trajet";
			ResultSet resultSet = statement.executeQuery(query);
			List<Bus> lesbus = new ArrayList<>();
			while (resultSet.next()) { 
				int identifiant = resultSet.getInt("id_bus"); 
				String  matricularion = resultSet.getString("matriculation"); 
				String ligneBus = resultSet.getString("ligne_bus"); 
				String garage= resultSet.getString("nom_parking");
				String etat = resultSet.getString("etat_bus");
				int id_trajet = resultSet.getInt("id_trajet") ;
				String source = resultSet.getString("source") ;
				String destination = resultSet.getString("destination") ;
				Trajet trajet = new Trajet(source,destination) ;
				trajet.setIdTrajet(id_trajet);
				
				Bus bus = new Bus(matricularion,garage,ligneBus,etat);
				bus.setTrajet(trajet);
				bus.setIdBus(identifiant); 
				lesbus.add(bus);
		}

			return lesbus;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}	
	}


	@Override
	public void deleteBus(int id) throws Exception {
		// TODO Auto-generated method stub
		try (Connection connection = DBConnexion.getConnection()) { 
			PreparedStatement preparedStatement = connection. prepareStatement("Delete From bus where id = ?"); 
			preparedStatement.setInt(1, id); 
			preparedStatement.executeUpdate(); 
		}
		catch (Exception e) { 
				throw new DAOException(e.getMessage()); 
		}
		
	}

	
	@Override
	public void createChauf(Chauffeur entity) throws Exception {		
		try (Connection connexion = DBConnexion.getConnection()) { 		
				PreparedStatement preparedStatement = connexion.prepareStatement("Insert into chauffeur (nom,prenom,adresse,email,telephone) values (?,?,?,?,?)");		
				preparedStatement.setString(1, entity.getNom());
				preparedStatement.setString(2, entity.getPrenom());
				preparedStatement.setString(3, entity.getAdresse());
				preparedStatement.setString(4, entity.getEmail());
				preparedStatement.setString(5, entity.getTelephone());
				preparedStatement.executeUpdate();
				
			} catch (Exception e) { 
				throw new DAOException(e.getMessage()); 
			}
		}
	
	@Override
	public void deleteChauf(int id) throws Exception {
		// TODO Auto-generated method stub
		
		try (Connection connection = DBConnexion.getConnection()) { 
			PreparedStatement preparedStatement = connection. prepareStatement("Delete * from chauffeur where id = ?"); 
			preparedStatement.setInt(1, id); 
			preparedStatement.executeUpdate(); 
			} 
		catch (Exception e) { 
				throw new DAOException(e.getMessage()); 
		}
	}


	@Override
	public void createTra(Trajet entity) throws Exception {		
		try (Connection connexion = DBConnexion.getConnection()) { 			
				PreparedStatement preparedStatement = connexion.prepareStatement("Insert into trajet (source,destination) values (?,?)");	
				preparedStatement.setString(1, entity.getSource()); 
				preparedStatement.setString(2, entity.getDestination());
				preparedStatement.executeUpdate();
		} catch (Exception e) { 
			throw new DAOException(e.getMessage()); 
		}	
	}	

	@Override
	public void deleteTra(int id) throws Exception {
		// TODO Auto-generated method stub
		try (Connection connection = DBConnexion.getConnection()) { 
			PreparedStatement preparedStatement = connection. prepareStatement("Delete * from trajet where id = ?"); 
			preparedStatement.setInt(1, id); 
			preparedStatement.executeUpdate(); 
			} 
		catch (Exception e) { 
				throw new DAOException(e.getMessage()); 
		}	
	}

	@Override
	public List<Trajet> listeTra() throws Exception {		
		try (Connection connection = DBConnexion.getConnection()) {
			java.sql.Statement statement = connection.createStatement(); 
			String query = "Select * from trajet";
			ResultSet resultSet = statement.executeQuery(query);
			List<Trajet> list = new ArrayList<>();
			while (resultSet.next()) { 
				int idTrajet = resultSet.getInt("id_trajet"); 
				String source = resultSet.getString("source"); 
				String destination = resultSet.getString("destination"); 
				Trajet trajet = new Trajet (source, destination); 
				trajet.setIdTrajet(idTrajet);
				list.add(trajet);
			}
			return list;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void updateBus(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <C> Bus searchBus(C critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chauffeur> listeChauf() throws Exception {
		try (Connection connection = DBConnexion.getConnection()) {
			java.sql.Statement statement = connection.createStatement(); 
			String query = "Select * From chauffeur";
			ResultSet resultSet = statement.executeQuery(query);
			List<Chauffeur> liste = new ArrayList<>();
			while (resultSet.next()) { 
				int id = resultSet.getInt("idChauf"); 
				String  nom = resultSet.getString("nom"); 
				String prenom = resultSet.getString("prenom"); 
				String adresse= resultSet.getString("adresse");
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				Chauffeur chauffeur = new Chauffeur(nom, prenom, telephone, email, adresse) ; 
				chauffeur.setIdChauff(id);				
				liste.add(chauffeur) ;
		}
			return liste;
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}	

	}

	@Override
	public void updateChauf(Chauffeur entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <C> Chauffeur searchChauf(C critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Recette> listeRecette() throws DAOException {		
		try (Connection connection = DBConnexion.getConnection()) {
			java.sql.Statement statement = connection.createStatement(); 
			String query = "Select * from recette";
			ResultSet resultSet = statement.executeQuery(query);
			List<Recette> list = new ArrayList<>();
			while (resultSet.next()) { 
				int idRecette = resultSet.getInt("id"); 
				String montant = resultSet.getString("montant"); 
				String date = resultSet.getString("date"); 
				Recette recette = new Recette (montant, date); 
				recette.setIdRecette(idRecette);
				list.add(recette);
			}
			return list;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	
	


}
