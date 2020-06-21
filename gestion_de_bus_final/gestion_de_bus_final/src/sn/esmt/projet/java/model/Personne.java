package sn.esmt.projet.java.model;



public class Personne implements Comparable<Personne>{
	
	protected int idUser;
	protected String nom;
	protected String prenom;
	protected String age;
	protected String telephone;
	protected String email;
	protected String dateDeNaissance;
	protected String lieuDeNaissance;
	protected String genre;
	protected String adresse;
	
	public Personne()  { 
		super();
		// TODO Auto-generated constructor stub
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

	

	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
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


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}


	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "Personne [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ ", dateDeNaissance=" + dateDeNaissance + ", lieuDeNaissance=" + lieuDeNaissance + ", genre=" + genre
				+ ", role=" + "]";
	}


	public void sepresenter() {
		System.out.println(this+"");
		
	}


	@Override
	public int compareTo(Personne arg0) {
		// TODO Auto-generated method stub
		return ((Integer)idUser).compareTo((Integer)arg0.idUser);
	}

	
	
	

}
