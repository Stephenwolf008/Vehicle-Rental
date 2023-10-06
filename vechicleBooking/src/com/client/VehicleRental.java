package com.client;

import java.util.ArrayList;
import java.util.List;

import com.dao.VehicleDao;
import com.dao.jdbc.VehicleDaoImpl;
import com.exception.DataAccessException;
import com.keyutil.KeyBoardUtil;
import com.model.BookingReport;
import com.model.BookingVO;
import com.model.Vehicle;
import com.model.VehicleCategory;

public class VehicleRental {
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws DataAccessException
	 */
	public static void main(String[] args) throws DataAccessException {
		VehicleDao ob = new VehicleDaoImpl();
		while (true) {
			System.out.println("Main Menu");
			System.out.println("1.Add a vehicle");
			System.out.println("2.Book a vehicle");
			System.out.println("3.Show this month's booking report");
			System.out.println("4.Exit");
			int choice = KeyBoardUtil.getInt("Please choose an option [1, 2, 3, 4]:");
			switch (choice) {
			case 1:
				System.out.println("Enter Vehicle details:");

				ArrayList<VehicleCategory> categories = ob.getVehicleCategory();
				for (int i = 0; i < categories.size(); i++) {
					System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
				}
				int choice2 = KeyBoardUtil.getInt("Choose a Vehicle Category [1,2,3]");

				System.out.println();
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleCat(choice2);
				vehicle.setRegNo(KeyBoardUtil.getString("Enter Vehicle registration no."));
				vehicle.setManufacturer(KeyBoardUtil.getString("Enter vehicle Manufacturer"));
				vehicle.setDailyRent(KeyBoardUtil.getInt("Enter daily rent"));
				vehicle.setMileage(KeyBoardUtil.getInt("Enter mileage"));
				vehicle.setFuelType(KeyBoardUtil.getString("Enter fuel type"));
				vehicle.setDescription(KeyBoardUtil.getString("Enter description"));

				ob.addVehicle(vehicle);
				System.out.println("Vehicle Added successfully");
				break;

			case 2:
				try {
					BookingVO booking = new BookingVO();
					System.out.println("Enter Booking details:");
					booking.setCustomerName(KeyBoardUtil.getString("Enter Your Name"));
					ArrayList<VehicleCategory> categories1 = ob.getVehicleCategory();
					for (int i = 0; i < categories1.size(); i++) {
						System.out.println((i + 1) + ". " + categories1.get(i).getCategoryName());
					}
					booking.setCategory(KeyBoardUtil.getInt("Enter category of vehicles: [1, 2, 3]"));
					List<Vehicle> vehicleList = ob.getVehicles(booking.getCategory());
					for (int i = 0; i < vehicleList.size(); i++) {
						System.out.println((i+1) + ". "+ vehicleList.get(i).toString());
					}
					booking.setRegNo(KeyBoardUtil.getString("Enter the registration Number"));
					booking.setTotalRent(KeyBoardUtil.getInt("Enter total rent"));
					booking.setToDate(KeyBoardUtil.getDate("Enter to-date (YYYY-MM-DD)"));
					booking.setFromDate(KeyBoardUtil.getDate("Enter from-date (YYYY-MM-DD):"));
					String payment = KeyBoardUtil.getString("Pay now: Y/N");
					if (payment.equalsIgnoreCase("Y")) {
						booking.setPaymentReceived(true);
					} else {
						booking.setPaymentReceived(false);
					}
					ob.addBooking(booking);
					System.out.println("Booking Done");

				} catch (Exception exception) {
					System.out.println("Invalid date format");
				}
				break;
			case 3:
				BookingReport report = new BookingReport();
				report.setReportData(ob.getBookingReport());
				report.showReportdata();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Enter valid Option");
				break;
			}

		}

	}
}
