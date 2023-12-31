package hotelreservation;


/**
 * File: AccountManagement.java
 * CMSC 495 Section 7380
 * Group 8
 * Author: Mario Bethancourt, Jules Torres, Megan Moore
 * Professor Hung Dao
 * Date: 11/21/2023
 * Description: This class represents an individual user account in the hotel reservation system.
 * Revisions
 * 11/21/2023 Everyone - Created the class, added methods.
 * 11/22/2023 Everyone - Implemented more method based on the other classes.
 * 11/23/2023 Everyone - Implemented methods related to storing user account information.
 * 11/24/2023 Everyone - Implemented error handling.
 * 11/25/2023 Jules, Mario - debugging.
 */

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class AccountManagement implements Serializable {
	private static final long serialVersionUID = 1L;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;
    private List<ReservationManagement> reservations;
    
    /**
     * COnstructor - AccountManagement
     * @param name
     * @param lastName
     * @param phoneNumber
     * @param address
     * @param username
     * @param password
     */
    public AccountManagement(String name, String lastName, String phoneNumber, String address, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.reservations = new ArrayList<>();
    }
    
    /**
     * Constructor - only takes username and password
     * @param username
     * @param password
     */
    public AccountManagement(String username, String password) {
    	this.username = username;
        this.password = password;
	}
    
    /**
     * updateUserInformation
     * @param name
     * @param lastName
     * @param phoneNumber
     * @param address
     */
	public void updateUserInfo(String name, String lastName, String phoneNumber, String address) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

	//Setters and getters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public List<ReservationManagement> getReservations() {
        return reservations;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void addReservation(ReservationManagement reservation) {
        reservations.add(reservation);
    }
    
    public void removeReservationByRoomNumber(String roomNumber) {
        reservations.removeIf(reservation -> reservation.getRoomNumber().equals(roomNumber));
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    /**
     * updatePassword
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public boolean updatePassword(String oldPassword, String newPassword) {
        // Check if the old password is correct
        if (checkPassword(oldPassword)) {
            // Update the password
            this.password = newPassword;
            return true; // Password updated successfully
        } else {
            return false; // Incorrect old password
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}