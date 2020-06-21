package sn.esmt.projet.java.model;



public class Trajet implements Comparable<Trajet> {

	private int idTrajet;
	private String source;
	private String destination;
	
	
	public Trajet( String source, String destination) {
		super();
	
		this.source = source;
		this.destination = destination;
		
	}

	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTrajet() {
		return idTrajet;
	}

	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	@Override
	public String toString() {
		return "Trajet [idTrajet=" + idTrajet + ", source=" + source + ", destination=" + destination 
				+ "]";
	}

	@Override
	public int compareTo(Trajet o) {
		// TODO Auto-generated method stub
		return ((Integer)idTrajet).compareTo((Integer)o.idTrajet);
	}
	
	
	
}
