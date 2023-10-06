/**
 * 
 */
package com.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.VehicleDao;
import com.exception.DataAccessException;
import com.model.BookingVO;
import com.model.ReportData;
import com.model.Vehicle;
import com.model.VehicleCategory;

public class VehicleDaoImpl extends BaseDAO implements VehicleDao {
	Connection con = null;
	PreparedStatement ps = null;

	private static final String GET_VEHICLES = "select * from vehicle where categoryid=?";
	private static final String GET_CATEGORY = "select * from category";
	private static final String GET_BOOKING = "select * from booking b WHERE " + 
			"MONTH(b.fromDate) = MONTH(CURDATE()) AND YEAR(b.fromDate) = YEAR(CURDATE())";
	private static final String ADD_VEHICLE = "insert into vehicle values(?,?,?,?,?,?,?)";
	private static final String ADD_BOOKING = "insert into booking (customername, categoryid, regno, fromdate, todate, totalrent, paymentreceived) values(?,?,?,?,?,?,?)";

	@SuppressWarnings("finally")
	@Override
	public ArrayList<Vehicle> getVehicles(int category) throws DataAccessException {

		ArrayList<Vehicle> vehicles = new ArrayList<>();
		try {
			con = getConnection();
			ps = con.prepareStatement(GET_VEHICLES);
			ps.setInt(1, category);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				vehicles.add(new Vehicle(result.getString(1), category, result.getString(3), result.getInt(4),
						result.getInt(5), result.getString(6), result.getString(7)));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Cannot be load..");
		} finally {
			releaseResources(con, ps);
			return vehicles;
		}
	}

	@Override
	public void addVehicle(Vehicle vehicle) throws DataAccessException {
		try {
			con = getConnection();
			ps = con.prepareStatement(ADD_VEHICLE);
			ps.setString(1, vehicle.getRegNo());
			ps.setInt(2, vehicle.getVehicleCat());
			ps.setString(3, vehicle.getManufacturer());
			ps.setInt(4, vehicle.getDailyRent());
			ps.setInt(5, vehicle.getMileage());
			ps.setString(6, vehicle.getFuelType());
			ps.setString(7, vehicle.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to load");
		} finally {
			releaseResources(con, ps);
		}
	}

	@Override
	public void addBooking(BookingVO booking) throws DataAccessException {
		try {
			con = getConnection();
			ps = con.prepareStatement(ADD_BOOKING);
			ps.setString(1, booking.getCustomerName());
			ps.setInt(2, booking.getCategory());
			ps.setString(3, booking.getRegNo());
			ps.setDate(4, booking.getFromDate());
			ps.setDate(5, booking.getToDate());
			ps.setInt(6, booking.getTotalRent());
			ps.setBoolean(7, booking.isPaymentReceived());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to load");
		} finally {
			releaseResources(con, ps);
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<BookingVO> getBooking() throws DataAccessException {

		ArrayList<BookingVO> booking = new ArrayList<>();
		try {
			con = getConnection();
			ps = con.prepareStatement(GET_BOOKING);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				booking.add(new BookingVO(result.getString(2), result.getInt(3), result.getString(4), result.getDate(5),
						result.getDate(6), result.getInt(7), result.getBoolean(8)));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Cannot be load..");
		} finally {
			releaseResources(con, ps);
			return booking;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<VehicleCategory> getVehicleCategory() throws DataAccessException {

		ArrayList<VehicleCategory> category = new ArrayList<>();
		try {
			con = getConnection();
			ps = con.prepareStatement(GET_CATEGORY);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				category.add(new VehicleCategory(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e) {
			throw new DataAccessException("cannot be load..");
		} finally {
			releaseResources(con, ps);
			return category;
		}
	}

	@Override
	public ArrayList<ReportData> getBookingReport() throws DataAccessException {
		ArrayList<BookingVO> booking = getBooking();
		ArrayList<ReportData> bookings = new ArrayList<>();
		bookings.add(new ReportData(0,0,0));
		bookings.add(new ReportData(0,0,0));
		bookings.add(new ReportData(0,0,0));


		for (BookingVO bookingVO : booking) {
			if(bookingVO.getCategory()==1){
				ReportData reportData = bookings.get(0);
				reportData.setNumberOfVehicles(reportData.getNumberOfVehicles()+1);
				if(bookingVO.isPaymentReceived()){
					reportData.setNumberOfVehiclesRented(reportData.getNumberOfVehiclesRented()+1);
					reportData.setTotalRentEarned(reportData.getTotalRentEarned()+bookingVO.getTotalRent()); 
				} 
				
			}
			else if(bookingVO.getCategory()==2){
				ReportData reportData = bookings.get(1);
				reportData.setNumberOfVehicles(reportData.getNumberOfVehicles()+1);
				if(bookingVO.isPaymentReceived()){
					reportData.setNumberOfVehiclesRented(reportData.getNumberOfVehiclesRented()+1);
					reportData.setTotalRentEarned(reportData.getTotalRentEarned()+bookingVO.getTotalRent()); 
				} 
				
			}
			else if(bookingVO.getCategory()==3){
				ReportData reportData = bookings.get(2);
				reportData.setNumberOfVehicles(reportData.getNumberOfVehicles()+1);
				if(bookingVO.isPaymentReceived()){
					reportData.setNumberOfVehiclesRented(reportData.getNumberOfVehiclesRented()+1);
					reportData.setTotalRentEarned(reportData.getTotalRentEarned()+bookingVO.getTotalRent()); 
				} 
				
			}
		}
		return bookings;

	}

}
