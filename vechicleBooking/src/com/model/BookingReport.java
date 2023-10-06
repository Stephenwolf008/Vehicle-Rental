package com.model;

import java.util.ArrayList;

public class BookingReport {

	ArrayList<ReportData> reportData = new ArrayList<>();

	public ArrayList<ReportData> getReportData() {
		return reportData;
	}

	public void setReportData(ArrayList<ReportData> bookings) {
		this.reportData = bookings;
	}

	public void showReportdata() {
		ArrayList<String> categories = new ArrayList<>();
		categories.add("Bus");
		categories.add("Car");
		categories.add("Truck");
		System.out.println("Category\tTotal_Vehicles\tTotal_Vehicles_Rented\tTotal_Rent_Earned");
		for(int i=0;i<3;i++){
			if(reportData.get(i).getNumberOfVehicles() != 0){
				System.out.println(categories.get(i)+"\t"+reportData.get(i).getNumberOfVehicles()+"\t"+reportData.get(i).getNumberOfVehiclesRented()+"\t"+reportData.get(i).getTotalRentEarned());
			}
		}
			
		}

	}


