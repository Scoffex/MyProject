package com.prova.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {

	private static DatabaseConnection instance;
	private Connection connection;

	private DatabaseConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/PostgresDS");
			this.connection = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnection getInstance()  {
		if (instance == null) {
			instance = new DatabaseConnection();
		} else
			try {
				if (instance.getConnection().isClosed()) {
					instance = new DatabaseConnection();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return instance;
	}
	
	public void  close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
