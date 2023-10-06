package com.model;

public class Vehicle {
	
		private String regNo;
	private VehicleCategory vehicleCat;
	private String manufacturer;
	private int dailyRent;
	private int mileage;
	private String fuelType;
	private String description;
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public VehicleCategory getVehicleCat() {
		return vehicleCat;
	}
	public void setVehicleCat(VehicleCategory vehicleCat) {
		this.vehicleCat = vehicleCat;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getDailyRent() {
		return dailyRent;
	}
	public void setDailyRent(int dailyRent) {
		this.dailyRent = dailyRent;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vehicle(String regNo, VehicleCategory vehicleCat, String manufacturer, int dailyRent, int mileage,
			String fuelType, String description) {
		super();
		this.regNo = regNo;
		this.vehicleCat = vehicleCat;
		this.manufacturer = manufacturer;
		this.dailyRent = dailyRent;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.description = description;
	}
	
}
