package sn.esmt.projet.java.model;

public class User implements Comparable<User> {

private int id;
private String login;
private String password;
private String role;




public User(int id, String login, String password, String role) {
	super();
	this.id = id;
	this.login = login;
	this.password = password;
	this.role = role;
}

public User(String login, String password, String role) {
	this.login = login;
	this.password = password;
	this.role = role;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Override
public int compareTo(User arg0) {
	// TODO Auto-generated method stub
	return ((Integer)id).compareTo((Integer)arg0.id);

}


}
