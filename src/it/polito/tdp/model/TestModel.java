package it.polito.tdp.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Simulator sim= new Simulator();
		int time=0;
		
		for(int i=0 ; i<200; i++ ){
			time=time+(int)((Math.random()*10)+1);
			sim.addClienti(time);
		}
		sim.run();
		System.out.format("Clienti totali arrivati: %d \n", sim.getClientiTot());
		System.out.format("Clienti soddisfatti: %d \n", sim.getClientiSoddisfatti());
		System.out.format("Clienti insoddisfatti: %d \n", sim.getClientiInsoddisfatti());
		
	}

}
