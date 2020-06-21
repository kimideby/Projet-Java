package sn.esmt.projet.java.model;

public class Chauffeur  {
	private int idChauff;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String adresse;
	
	public Chauffeur(String nom, String prenom, String telephone, String email, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;		
		this.adresse = adresse;
	}

	public int getIdChauff() {
		return idChauff;
	}

	public void setIdChauff(int idChauff) {
		this.idChauff = idChauff;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
