package app.db;

import javax.persistence.Entity;

@Entity
public class RestaurantQueue {
	private @javax.persistence.Id String Id;
	private int totalTimes; // in seconds
	private int numEntries; 
	
	public RestaurantQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public RestaurantQueue(String id, int totalTimes, int numeEntries) {
		this.Id = id;
		this.totalTimes = totalTimes;
		this.numEntries = numeEntries;
	}
	
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}
	
	public int getNumEntries() {
		return numEntries;
	}
	
	public int getTotalTimes() {
		return totalTimes;
	}
	
	public void setNumEntries(int numEntries) {
		this.numEntries = numEntries;
	}
	
	public void setTotalTimes(int totalTimes) {
		this.totalTimes = totalTimes;
	}
}
