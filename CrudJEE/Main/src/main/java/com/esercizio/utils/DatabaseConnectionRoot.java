package com.esercizio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionRoot {


	    private static DatabaseConnectionRoot instance;
	    private Connection connection;
	    private String url = "jdbc:postgresql://localhost:5432/postgres";
	    private String username = "postgres";
	    private String password = "root";

	    private DatabaseConnectionRoot() throws SQLException {
	        try {
	            Class.forName("org.postgresql.Driver");
	            this.connection = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }
	    }

	    public Connection getConnection() {
	        return connection;
	    }
	    
	    
	    public void close() {
	    	try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    public static DatabaseConnectionRoot getInstance() throws SQLException {
	        if (instance == null) {
	            instance = new DatabaseConnectionRoot();
	        } else if (instance.getConnection().isClosed()) {
	            instance = new DatabaseConnectionRoot();
	        }

	        return instance;
	    }
}
