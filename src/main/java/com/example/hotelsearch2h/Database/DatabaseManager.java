package com.example.hotelsearch2h.Database;

import com.example.hotelsearch2h.models.Booking;
import com.example.hotelsearch2h.models.Room;
import com.example.hotelsearch2h.models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseManager {

    // JDBC URL for SQLite database
    private static final String JDBC_URL = "jdbc:sqlite:hotel.db";

    // This function will get data from SQLite database that we called hotel.db
    // if username and password match with database, it will return that user; otherwise, it will return null
    // we let LoginController call this function
    public static User loginUser(String username, String password) {
        // use try to close when finsihed (prevent resource leaks)
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            // query to retrieve user data based on username and password
            String sql = "SELECT * FROM User WHERE email = ? AND password = ?";
            //tell it to run the prepared statement
            //and what placeholder to fill
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                // Execute the query and return data
                ResultSet rs = stmt.executeQuery();

                // Check if user exists
                if (rs.next()) {
                    // User found, now asseble into object so we can work with it
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setNumberOfAdults(rs.getInt("numberOfAdults"));
                    user.setNumberOfChildren(rs.getInt("numberOfChildren"));
                    return user;
                }
            }
            // catch any errors
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return null if user not found or error occurred
        return null;
    }


    public static String registerUser(String username, String password, String email, String phoneNumber, int numberOfAdults, int numberOfChildren) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            // Check if user with the same email already exists
            if (userExists(conn, email)) {
                return "Error:User with this email already exists";
            }

            // Prepare SQL statement to insert user data
            String sql = "INSERT INTO User (name, email, password, phoneNumber, numberOfAdults, numberOfChildren) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, phoneNumber);
                stmt.setInt(5, numberOfAdults);
                stmt.setInt(6, numberOfChildren);

                // Execute the INSERT statement
                stmt.executeUpdate();

                return "User registered successfully.";
            }
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // helper method to check if user with the same email already exists
    private static boolean userExists(Connection conn, String email) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM User WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        }
        return false;
    }


    public static ArrayList<Room> getAllRoomsFromDB() {
        ArrayList<Room> rooms = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            // Prepare SQL statement to retrieve all rooms
            String sql = "SELECT * FROM Room";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Execute query
                ResultSet rs = stmt.executeQuery();
                // go over the result set and create Room objects
                while (rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getInt("id"));
                    room.setHotelName(rs.getString("hotelName"));
                    room.setCity(rs.getString("city"));
                    room.setPostalCode(rs.getString("postalCode"));
                    room.setCountry(rs.getString("country"));
                    room.setNumberOfSingleBeds(rs.getInt("numberOfSingleBeds"));
                    room.setNumberOfDoubleBeds(rs.getInt("numberOfDoubleBeds"));
                    room.setHasWifi(rs.getBoolean("hasWifi"));
                    room.setHasRoomService(rs.getBoolean("hasRoomService"));
                    room.setbigBathroom(rs.getBoolean("BigBathroom"));
                    room.setCostPerNight(rs.getInt("costPerNight"));
                    // Add Room to the list
                    rooms.add(room);
                }
            }
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
        }
        return rooms;
    }


    public static ArrayList<Booking> getAllBookingsFromDB() {
        ArrayList<Booking> bookings = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            String sql = "SELECT *, strftime('%Y-%m-%d', startDate) AS startDateStr, strftime('%Y-%m-%d', endDate) AS endDateStr FROM Booking";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Booking booking = new Booking();
                    booking.setId(rs.getInt("id"));
                    // Retrieve startDate and endDate as strings
                    String startDateStr = rs.getString("startDateStr");
                    String endDateStr = rs.getString("endDateStr");
                    // Convert strings to LocalDate objects
                    booking.setStartDate(LocalDate.parse(startDateStr));
                    booking.setEndDate(LocalDate.parse(endDateStr));
                    booking.setRoomId(rs.getInt("roomId"));
                    booking.setUserID(rs.getInt("userId"));
                    booking.setCancelled(rs.getBoolean("cancelled"));
                    bookings.add(booking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // access the booking
    public static boolean insertNewBookingIntoDB(Booking booking) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            // SQL statement to insert booking data
            String sql = "INSERT INTO Booking (startDate, endDate, roomId, userId, cancelled) VALUES (strftime('%Y-%m-%d', ?), strftime('%Y-%m-%d', ?), ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Set parameters for the INSERT statement
                stmt.setString(1, booking.getStartDate().toString());
                stmt.setString(2, booking.getEndDate().toString());
                stmt.setInt(3, booking.getRoomId());
                stmt.setInt(4, booking.getUserID());
                stmt.setBoolean(5, booking.isCancelled());

                //  insert statement
                int rowsInserted = stmt.executeUpdate();

                // true if at least one row was inserted, false otherwise
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
            return false;
        }
    }


}
