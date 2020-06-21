package sn.esmt.projet.java.model;

public class Recette {
	
	private int idRecette;
	private String montant;
	private String date;
	
	public Recette(String montant, String date) {
		super();
		this.montant = montant;
		this.date = date;
	}

	public int getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
