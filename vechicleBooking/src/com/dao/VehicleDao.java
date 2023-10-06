/**
 * 
 */
package com.dao;

import java.util.ArrayList;
import com.exception.DataAccessException;
import com.model.BookingVO;
import com.model.ReportData;
import com.model.Vehicle;
import com.model.VehicleCategory;

public interface VehicleDao{
   ArrayList<BookingVO> getBooking() throws DataAccessException;
   ArrayList<Vehicle> getVehicles(int category) throws DataAccessException;
   ArrayList<VehicleCategory> getVehicleCategory() throws DataAccessException;
   void addVehicle(Vehicle vehicle) throws DataAccessException;
   void addBooking(BookingVO booking) throws DataAccessException;
   ArrayList<ReportData> getBookingReport() throws DataAccessException;
}
