package introsmp;

import java.util.ArrayList;

public class Controller {
	private CalTrain caltrain;
	private Frame f;
	
	public Controller() {
		caltrain = new CalTrain();
		f = new Frame(this);
		
		caltrain.setF(f);
	}
	
	public void addtrain(int c) {
		caltrain.addTrain(c);
		//append to log textpane in Frame
	}
	
	public boolean addPassenger(int s, int d) {
		
		return false;
	}
	
	public ArrayList<Station> getStations() {
		
		return caltrain.getStation();
	}
	
	
}
