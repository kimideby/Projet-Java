package sn.esmt.projet.java.model;

public class Bus implements Comparable<Bus> {

	private int idBus;
	private String matriculation;
	private String garage;
	private String ligneBus;
	private String etatDuBus;
	private Trajet trajet;
	private Chauffeur chauffeur;
	
	
	public Bus(String matriculation, String garage, String ligneBus, String etatDuBus, Trajet trajet) {
		super();
		this.matriculation = matriculation;
		this.garage = garage;
		this.ligneBus = ligneBus;
		this.etatDuBus = etatDuBus;
		this.trajet = trajet;
	}
	
	public String getGarage() {
		return garage;
	}
	
	public void setGarage(String garage) {
		this.garage = garage;
	}
	
	public Chauffeur getChauffeur() {
		return chauffeur;
	}
	
	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}
	
	public  Trajet getTrajet() {
		return trajet;
	}
	
	public  void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
		
	}	
	
	public Bus( String matriculation, String nomParcking, String ligneBus2, String etatDuBus) {		
		this.matriculation = matriculation;
		this.garage = nomParcking;
		this.ligneBus = ligneBus2;
		this.etatDuBus = etatDuBus;
	}
	
	public int getIdBus() {
		return idBus;
	}
	
	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
	
	public String getMatriculation() {
		return matriculation;
	}
	
	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}
	
	public String getNomParcking() {
		return garage;
	}
	public void setNomParcking(String nomParcking) {
		this.garage = nomParcking;
	}
	public String getLigneBus() {
		return ligneBus;
	}
	public void setLigneBus(String ligneBus) {
		this.ligneBus = ligneBus;
	}

	public String getEtatDuBus() {
		return etatDuBus;
	}
	public void setEtatDuBus(String etatDuBus) {
		this.etatDuBus = etatDuBus;
	}
	@Override
	public int compareTo(Bus o) {
		// TODO Auto-generated method stub
		return ((Integer)idBus).compareTo((Integer)o.idBus);
	}
	
	
	
	
}
