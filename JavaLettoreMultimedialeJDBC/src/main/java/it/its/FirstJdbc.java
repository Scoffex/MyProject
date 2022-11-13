package it.its;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FirstJdbc {

		public static void createTable(String driver, String url, String username, String password) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			 Statement stmt = conn.createStatement();
	
			String sql = "CREATE TABLE IF NOT EXISTS ElemMultimediale " +
	                   "(id int NOT NULL AUTO_INCREMENT, " +
	                   " Title VARCHAR(50), " + 
	                   " Durata INTEGER, " + 
	                   " Volume INTEGER, " + 
	                   " Luminosita INTEGER, " + 
	                   " Categoria VARCHAR(50), " +
	                   " PRIMARY KEY ( id ))"; 

	         stmt.executeUpdate(sql);
	         System.out.println("Created table in given database...");
	     	System.out.println("Connection success");
		} catch (Exception e) {
			System.out.println("Tabella già esistente o connessione non riuscita");
			e.printStackTrace();
		}

	}

}
