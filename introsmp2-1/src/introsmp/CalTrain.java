package introsmp;

import java.util.ArrayList;

public class CalTrain {
	
	private static ArrayList<Station> stations;
	private ArrayList<Train> trains;
	private int trainID;
	private int passID;
	private Frame f;
	
	public CalTrain () {
		this.stations = new ArrayList<Station>();
		this.trains =  new ArrayList<Train>();
		
	}
	
	public static void intialize() {
		for (int i=1;i<=8;i++) {
			Station s = new Station(i);
		}
	}
	
	
	
	public void addTrain (int count) {
		
	}
	
	public void boardPassenger () {
		
	}

	public static ArrayList<Station> getStation() {
		return stations;
	}

	public static void setStation(ArrayList<Station> station) {
		CalTrain.stations = station;
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}

	public void setTrains(ArrayList<Train> trains) {
		this.trains = trains;
	}

	public Frame getF() {
		return f;
	}

	public void setF(Frame f) {
		this.f = f;
	}
	
	

	

}
