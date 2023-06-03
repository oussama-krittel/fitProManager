package com.example.fitProManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class module {
    static public Connection connectToDb(){
        String jdbcURL = "jdbc:mysql://localhost:3306/gymdatabase";
        String username = "root";
        String password = "";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to MySQL database!");
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public void closeConnection(Connection connection){
        // Close the connection
        try {
            connection.close();
            System.out.println("Disconnected from MySQL database!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //this password hashs the password that will be stored in the data base
    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hashed password bytes
            byte[] hashedBytes = md.digest();

            // Convert the hashed bytes to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                sb.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
            }

            // Return the hashed password as a string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    //this function check if a hash is identical to a string it will be used to check if the password entered in the login is in the database
    public static boolean isPasswordMatch(String password, String hashedPassword) {
        String hashedInput = hashPassword(password);
        return hashedInput.equals(hashedPassword);
}




}