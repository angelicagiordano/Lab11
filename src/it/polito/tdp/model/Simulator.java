package it.polito.tdp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import it.polito.tdp.model.Event.EventType;

public class Simulator {
	//parametri di simulazione
	private Map<Integer,Tavolo> tavoli;
	
	//stato del modello
	private int tavoliTot;
	private Tavolo bancone;
	
	//variabili di interesse
	private int clientiTot=0;
	private int clientiSoddisfatti=0;
	private int clientiInsoddisfatti=0;
	
	//lista degli eventi
	PriorityQueue<Event> queue;

	public Simulator() {
		super();
		tavoli= new TreeMap<Integer,Tavolo>();
		this.queue= new PriorityQueue<Event>();
		
		this.addTavoli();
		
	}
	public void addTavoli(){
		Tavolo bancone= new Tavolo(0,0,true);
		tavoli.put(bancone.getId(), bancone);
		for(int i=1; i<6; i++){
		Tavolo t= new Tavolo(i, 4, true);
		tavoli.put(t.getId(), t);
				}
		for(int i=6; i<10; i++){
			Tavolo t= new Tavolo(i, 6, true);
			tavoli.put(t.getId(), t);
			
					}
		for(int i=10; i<14; i++){
			Tavolo t= new Tavolo(i, 8, true);
			tavoli.put(t.getId(), t);
			
					}
		for(int i=14; i<16; i++){
			Tavolo t= new Tavolo(i, 10, true);
			tavoli.put(t.getId(), t);
			
					}



	}
	public void addClienti(int time){
		int numeroPersone=(int)(Math.random()*10+1);
		float tolleranza=(float)(Math.random());
		int durata= (int)((Math.random()*2+1)*60);
		Gruppo g= new Gruppo( durata, numeroPersone,  tolleranza);
		queue.add(new Event(time, EventType.ARRIVO_GRUPPO_CLIENTI, g));
	}

	public void run(){
		while(!queue.isEmpty()){
			Event e= queue.poll(); //svuota la coda estraendo il primo elemento, finisce quando la coda è vuota
			//elaboro l'evento
			//fa cose diverse a seconda del tipo di evento
			
			switch(e.getType()){
			case ARRIVO_GRUPPO_CLIENTI:
				int indice=this.trovaPosto(e);
				if(indice>0){
					
					
						//accomodo i clienti
						tavoli.get(indice).setFree(false);
						e.getG().setT(tavoli.get(indice));
						
						this.clientiTot+=e.getG().getNumPersone();
						this.clientiSoddisfatti+=e.getG().getNumPersone();;
						this.tavoliTot--;
						
						//durata dell'affito dell'auto
						//aggiungo un nuovo evento in un tempo pari al tempo presente +durata, l'evento sarà auro restituita
						queue.add(new Event( e.getTime()+e.getG().getDurata(),   EventType.TAVOLO_LIBERATO,e.getG()));
						System.out.format("Tempo=%d-->Tavolo %d da %d posti occupato da %d persone libero tra %d minuti \n",e.getTime(),e.getG().getT().getId(), e.getG().getT().getNumPostiMax(),e.getG().getNumPersone(), e.getG().getDurata());
					   // System.out.format("Tavoli da 4= %d, da 6=%d, da 8=%d, da 10=%d\n", this.tavoli4posti, this.tavoli6posti, this.tavoli8posti, this.tavoli10posti);
						
					
					
				}else{
					if(indice==0){
						e.getG().setT(tavoli.get(indice));
						this.clientiTot+=e.getG().getNumPersone();
						this.clientiSoddisfatti+=e.getG().getNumPersone();;
						this.tavoliTot--;
						
						
					}else{
					//capire come funziona la tolleranza
					this.clientiInsoddisfatti+=e.getG().getNumPersone();
					this.clientiTot+=e.getG().getNumPersone();; //numero clienti totali arrivati al deposito
					System.out.format("Time %d- %d clienti insoddisfatti\n", e.getTime(), e.getG().getNumPersone());
					}
					}
				break;
			case TAVOLO_LIBERATO:// l'evento non genera nuovi eventi
				tavoli.get(e.getG().getT().getId()).setFree(true);
				System.out.format("Time=%d Tavolo %d da %d posti liberato\n",e.getTime(),e.getG().getT().getId(), e.getG().getT().getNumPostiMax());
				
				break;
			} 
		}

	}
	public int trovaPosto(Event e){
		int flag=-1;
		
		if(flag==-1){
		for(int i=1; i<16; i++){
		if(e.getG().getNumPersone()<=tavoli.get(i).getNumPostiMax() && e.getG().getNumPersone()>= (tavoli.get(i).getNumPostiMax()*0.5) && tavoli.get(i).isFree()==true ){
			flag= i;
			break;
		}}}
		
		/*if(numPersone>= 3 &&  numPersone<=6 && this.tavoli6posti>0 ){
			tavoli6posti--;
			e.setPostiTavolo(6);
			return true;
		}
		if(numPersone>= 4 &&  numPersone<=8 && this.tavoli8posti>0 ){
			tavoli8posti--;
			e.setPostiTavolo(8);
			return true;
		}
		if(numPersone>= 5 &&  numPersone<=10 && this.tavoli10posti>0 ){
			tavoli10posti--;
			e.setPostiTavolo(10);
			return true;
		}}*/
		if(flag==-1){
			double decisionale= Math.random();
			if(e.getG().getTolleranza()< decisionale){
				
			 flag=0;
		}}
		return flag;
	}
		public int getTavoliTot() {
		return tavoliTot;
	}

	public int getClientiTot() {
		return clientiTot;
	}

	public int getClientiSoddisfatti() {
		return clientiSoddisfatti;
	}

	public int getClientiInsoddisfatti() {
		return clientiInsoddisfatti;
	}
	
	

}
