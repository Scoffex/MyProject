package it.its;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import it.its.bean.Audio;
import it.its.bean.Filmato;
import it.its.bean.Immagine;

public class Crud {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "";

	public static void createTable() {
		// TODO Auto-generated method stub
		try {

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS ElemMultimediale " + "(id int NOT NULL AUTO_INCREMENT, "
					+ " Title VARCHAR(50), " + " Durata INTEGER, " + " Volume INTEGER, " + " Luminosita INTEGER, "
					+ " Categoria VARCHAR(50), " + " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);
			System.out.println("Tabella creata correttamente");

		} catch (Exception e) {
			System.out.println("Tabella già esistente o connessione non riuscita");
			e.printStackTrace();
		}

	}

	public static void readAll() {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ElemMultimediale";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("Title");
				int durata = rs.getInt("Durata");
				int volume = rs.getInt("Volume");
				int luminosita = rs.getInt("Luminosita");
				String categoria = rs.getString("Categoria");
				System.out.println(
						"ID: " + id + "\n" + "TITLE: " + title + "\n" + "DURATA: " + durata + "\n" + "VOLUME: " + volume
								+ "\n" + "LUMINOSITA': " + luminosita + "\n" + "CATEGORIA: " + categoria + "\n");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object getById(int id) {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			String insert = "SELECT Title, Durata, Volume, Luminosita, Categoria FROM ElemMultimediale WHERE id = ?";
			PreparedStatement prst = conn.prepareStatement(insert);
			prst.setInt(1, id);
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				String title = rs.getString("Title");
				int durata = rs.getInt("Durata");
				int volume = rs.getInt("Volume");
				int luminosita = rs.getInt("Luminosita");
				String categoria = rs.getString("Categoria");
			
		
				if (categoria.equalsIgnoreCase("FILMATO")){
					Filmato filmato = new  Filmato(title, durata, volume, luminosita);
					return filmato;
				} else if (categoria.equalsIgnoreCase("AUDIO")) {
					Audio audio = new Audio(title, durata, volume);
					return audio;
				} else {
					Immagine immagine = new  Immagine(title, luminosita);
					return immagine;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	public static void insertMultimedia(Object obj) {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			String insert = "INSERT INTO ElemMultimediale (Title, Durata, Volume, Luminosita, Categoria) VALUES  (?, ?, ?, ?, ?)";
			PreparedStatement prst = conn.prepareStatement(insert);
			if (obj.getClass() == Filmato.class) {
				Filmato filmato = (Filmato) obj;
				prst.setString(1, filmato.getTitolo());
				prst.setInt(2, filmato.getDurata());
				prst.setInt(3, filmato.getVolume());
				prst.setInt(4, filmato.getLuminosità());
				prst.setString(5, "FILMATO");

			} else if (obj.getClass() == Audio.class) {
				Audio audio = (Audio) obj;
				prst.setString(1, audio.getTitolo());
				prst.setInt(2, audio.getDurata());
				prst.setInt(3, audio.getVolume());
				prst.setNull(4, Types.INTEGER);
				prst.setString(5, "AUDIO");
			} else {
				Immagine img = (Immagine) obj;
				prst.setString(1, img.getTitolo());
				prst.setNull(2, Types.INTEGER);
				prst.setNull(3, Types.INTEGER);
				prst.setInt(4, img.getLuminosità());
				prst.setString(5, "IMMAGINE");
			}
			System.out.println("Elemento aggiunto correttamente");
			prst.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
