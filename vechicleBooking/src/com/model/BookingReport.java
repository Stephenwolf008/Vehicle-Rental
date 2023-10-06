package com.model;

public class BookingReport {
	
	private String vehicleType;
	private int numberOfVehicles;
	private int numberOfVehiclesRented;
	private int totalRentEarned;
	
	public String getVechileType() {
		return vehicleType;
	}
	public void setVechileType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
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
	public BookingReport(String vehicleType, int numberOfVehicles, int numberOfVehiclesRented, int totalRentEarned) {
		super();
		this.vehicleType = vehicleType;
		this.numberOfVehicles = numberOfVehicles;
		this.numberOfVehiclesRented = numberOfVehiclesRented;
		this.totalRentEarned = totalRentEarned;
	}
	
	
}
