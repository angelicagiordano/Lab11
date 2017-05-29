package it.polito.tdp.model;


public class Event implements Comparable<Event> {

   public enum EventType{ARRIVO_GRUPPO_CLIENTI, TAVOLO_LIBERATO}; //gruppo di costanti a cui do un tipo e un  nome, enum è una classe con costanti statiche dentro
	

	private int time;
	private EventType type;
	private Gruppo g;
	
	

		



	public Event(int time, EventType type, Gruppo g) {
		super();
		this.time = time;
		this.type = type;
		this.g = g;
	}
	





	

	public int getTime() {
		return time;
	}








	public void setTime(int time) {
		this.time = time;
	}








	public EventType getType() {
		return type;
	}








	public void setType(EventType type) {
		this.type = type;
	}








	public Gruppo getG() {
		return g;
	}








	public void setG(Gruppo g) {
		this.g = g;
	}








	@Override
	public int compareTo(Event arg0) {
		// TODO Auto-generated method stub
		return this.time-arg0.getTime();
	}

}
