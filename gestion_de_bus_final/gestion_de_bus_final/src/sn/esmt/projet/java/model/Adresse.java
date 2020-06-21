package sn.esmt.projet.java.model;

public class Adresse implements Comparable<Adresse>{

	private int idAdresse;
	private String pays;
	private String ville;
	
	
	

	public Adresse(String pays, String ville) {
		super();
		this.pays = pays;
		this.ville = ville;
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTrajet() {
		return idAdresse;
	}

	public void setIdTrajet(int idTrajet) {
		this.idAdresse = idTrajet;
	}

	


	@Override
	public int compareTo(Adresse o) {
		// TODO Auto-generated method stub
		return ((Integer)idAdresse).compareTo((Integer)o.idAdresse);
	}
	
	
}
