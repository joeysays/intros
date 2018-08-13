/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsmp;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Belle
 */
public class Passenger {
    public int id;
    public int start;
    public int end;
    
    private Train boarded;
    private ArrayList<Station> stations;
    private Thread thread;
    private ReentrantLock lock = new ReentrantLock();
    private Frame f;
    
    public Passenger(int id, int start, int end){
        this.id = id;
        this.start = start;
        this.end = end;
    }
    
    public Passenger (int id, int start, int end, ArrayList<Station> stations, Frame f) {
    	this.id = id;
    	this.start = start;
    	this.end = end;
    	this.stations = stations;
    	this.f = f;
    			
    }
    
    public void station_wait_for_train (Station s) {
    	
    }
    
    public boolean station_on_board(Station s) {
    	return true;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public void start() {
		if (thread == null) {
			thread = new Thread ();
			System.out.println("Passenger " + id + " thread started.");
			thread.start();
		}
	}
    
    
}
