package it.polito.tdp.model;

public class Gruppo {
	
	private int durata;
	private int numPersone;
	private float tolleranza;
	private Tavolo t;
	
	public Gruppo(int durata, int numPersone, float tolleranza) {
		super();
		this.durata = durata;
		this.numPersone = numPersone;
		this.tolleranza = tolleranza;
	}

	
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}


	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(int tolleranza) {
		this.tolleranza = tolleranza;
		
	}


	public Tavolo getT() {
		return t;
	}


	public void setT(Tavolo t) {
		this.t = t;
	}
	

	
}
