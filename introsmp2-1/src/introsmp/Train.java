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
public class Train {
    
    public ArrayList<Passenger> passengers = new ArrayList<>();
    public int trainNo;
    public int currStat;
    public int capacity;
    public int prevStat;
    
    private Thread t;
    private ArrayList<Station> stations;
    private ReentrantLock lock = new ReentrantLock();
    private Frame frame;
    
    public Train(int trainNo, int currStat, int capacity, int prevStat) {
        this.trainNo = trainNo;
        this.currStat = currStat;
        this.capacity = capacity;
        this.prevStat = prevStat;
        
    }
    
    public Train (int trainNo, int capacity, ArrayList<Station> stations, Frame f) {
        this.trainNo = trainNo;
        this.currStat = currStat;
        this.capacity = capacity;
        this.prevStat = prevStat;
        this.stations = stations;
        this.passengers = new ArrayList<Passenger>();
        this.frame = f; 
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
    
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
	
	public void proceed_next_station () {
		//our move function
	}
	
	public void check_leaving_passengers() {
		
	}
	
	public void start () {
		//start the thread of the train
		if (t == null) {
			t = new Thread();
			System.out.println("Train " + trainNo + " thread is now starting");
			t.start();
		}
	}
    
    public void run() {
    	//thread
    	
    	while (true) {
    		System.out.println("Train no: " + trainNo + "thread started.");
    		
    		lock.lock();
    		try {
    			Thread.sleep(3000);
    			check_leaving_passengers();
    			proceed_next_station();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		} finally {
    			lock.unlock();
    		}
    		
    	}
    }
    

}
