package com.model;

public class ReportData {
    
    private int numberOfVehicles;
    private int numberOfVehiclesRented;
    private int totalRentEarned;



    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getNumberOfVehiclesRented() {
        return numberOfVehiclesRented;
    }

    public void setNumberOfVehiclesRented(int numberOfVehiclesRented) {
        this.numberOfVehiclesRented = numberOfVehiclesRented;
    }

    public int getTotalRentEarned() {
        return totalRentEarned;
    }

    public void setTotalRentEarned(int totalRentEarned) {
        this.totalRentEarned = totalRentEarned;
    }

    public ReportData(int numberOfVehicles, int numberOfVehiclesRented, int totalRentEarned) {
		super();
		
		this.numberOfVehicles = numberOfVehicles;
		this.numberOfVehiclesRented = numberOfVehiclesRented;
		this.totalRentEarned = totalRentEarned;
	}
}
