/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsmp;

import java.util.ArrayList;

/**
 *
 * @author Belle
 */
public class Station {
    
    public ArrayList<Passenger> passengers = new ArrayList<>();
    public ArrayList<Train> trains = new ArrayList<>();
    public int stationNo;
    public boolean isOccupied;

    public Station(int stationNo, boolean isOccupied) {
        this.stationNo = stationNo;
        this.isOccupied = isOccupied;
    }
    
    public Station(int stationNo) {
    	this.stationNo = stationNo;
    	this.passengers = new ArrayList<Passenger>();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
    
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
    
    public void addTrain(Train train){
        trains.add(train);
    }
    
    public void removeTrain(Train train){
        trains.remove(train);
    }

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}

	public void setTrains(ArrayList<Train> trains) {
		this.trains = trains;
	}

	public int getStationNo() {
		return stationNo;
	}

	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
    
    
}
