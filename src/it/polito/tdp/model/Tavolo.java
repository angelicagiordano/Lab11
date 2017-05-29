package it.polito.tdp.model;

public class Tavolo {

	int id;
	int numPostiMax;
	boolean free;
	public Tavolo(int id, int numPostiMax, boolean free) {
		super();
		this.id = id;
		this.numPostiMax = numPostiMax;
		this.free = free;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumPostiMax() {
		return numPostiMax;
	}
	public void setNumPostiMax(int numPostiMax) {
		this.numPostiMax = numPostiMax;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	@Override
	public String toString() {
		return ""+this.getId();
	}
	
	
	
}
